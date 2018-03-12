package com.example.zhujiaxiang.forwork.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zhujiaxiang.forwork.R;
import com.example.zhujiaxiang.forwork.tools.Md5Activity;

import org.json.JSONException;
import org.json.JSONObject;
import org.kymjs.kjframe.KJHttp;
import org.kymjs.kjframe.http.HttpCallBack;
import org.kymjs.kjframe.http.HttpConfig;

/**
 * Created by zhujiaxiang on 18/3/9.
 */

public class ChangePsdActivity extends AppCompatActivity {
    Md5Activity md5Activity = new Md5Activity();
    public EditText edit_userphone;
    public EditText edit_pwdBegin;
    public EditText edit_pwdAfter;
    public EditText edit_pwdAfterAgain;
    public Button btn_pwd;
    public String state = "1" ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepsd);
        edit_pwdBegin = (EditText) findViewById(R.id.edit_oldpasswd);
        edit_pwdAfter = (EditText) findViewById(R.id.edit_newpasswd);
        edit_pwdAfterAgain = (EditText) findViewById(R.id.edit_newpasswdagain);
        btn_pwd = (Button) findViewById(R.id.btn_makesure);
        edit_userphone = (EditText) findViewById(R.id.edit_userphoneNum);
        btn_pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String pwdBeginNum = edit_pwdBegin.getText().toString();
                String  userphoneNum = edit_userphone.getText().toString();
                final String pwdAfterNum = edit_pwdAfter.getText().toString();
                final String pwdAfterAgainNum = edit_pwdAfterAgain.getText().toString();
                final String md5pwdBegin = md5Activity.encode(pwdBeginNum);
                final String md5pwdAfter = md5Activity.encode(pwdAfterNum);
                final String md5pwdAfterAgain = md5Activity.encode(pwdAfterAgainNum);
                final int pwdAfterLength = pwdAfterNum.length();
                final int pwdAfterAgainLength = pwdAfterAgainNum.length();

                //                Toast.makeText(MainActivity.this,"1",Toast.LENGTH_LONG).show();
                KJHttp kjHttp = new KJHttp();
                final org.kymjs.kjframe.http.HttpParams params = new org.kymjs.kjframe.http.HttpParams();
                HttpConfig httpconfig = new HttpConfig();
                httpconfig.cacheTime = 0;

                params.put("contact",userphoneNum);
                params.put("password",md5pwdBegin);
//                params.put("passwordAgain",md5pwdAfterAgain);
//                Toast.makeText(MainActivity.this,userphoneNum, Toast.LENGTH_LONG).show();
                if (pwdAfterNum.equals(pwdAfterAgainNum)){
                    params.put("passwordAgain",md5pwdAfterAgain);
                    Toast.makeText(ChangePsdActivity.this,"1", Toast.LENGTH_LONG).show();
                }
                kjHttp.post("http://35.194.101.143/jy/changepwd.php", params, new HttpCallBack() {

                    @Override
                    public void onSuccess(String t) {
                        super.onSuccess(t);
                        try {
                            JSONObject jsonobj = new JSONObject(t);
                            state = jsonobj.get("state").toString();
//                            Toast.makeText(ChangePasswordActivity.this,state, Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        switch (state){
                            //  "state"==0时手机号错误
                            case "0":
                                new AlertDialog.Builder(ChangePsdActivity.this)
                                        .setTitle("提示")
                                        .setMessage("手机号错误")
                                        .setPositiveButton("好的", null)
                                        .show();
                                edit_userphone.getText().clear();
                                break;
                            //  "state"==1时旧密码错误
                            case  "1":
                                new AlertDialog.Builder(ChangePsdActivity.this)
                                        .setTitle("提示")
                                        .setMessage("旧密码错误")
                                        .setPositiveButton("好的", null)
                                        .show();
                                edit_pwdBegin.getText().clear();
                                break;
                            /**
                             *  "state"==2时判断密码长度,符合要求设置新密码，并将md5加密后的密码存入数据库
                             *  有可能出现两次密码不同情况
                             */
                            case  "2":
                                if (pwdAfterLength < 6 ||pwdAfterLength > 12 ||pwdAfterAgainLength < 6||pwdAfterAgainLength > 12)
                                {
                                    new AlertDialog.Builder(ChangePsdActivity.this)
                                            .setTitle("提示")
                                            .setMessage("新密码设置不符合要求")
                                            .setPositiveButton("好的", null)
                                            .show();
                                    edit_pwdAfter.getText().clear();
                                    edit_pwdAfterAgain.getText().clear();
                                }else {
                                    if (pwdAfterNum.equals(pwdAfterAgainNum) == true) {
                                        params.put("passwordAgain",md5pwdAfterAgain);
                                        new AlertDialog.Builder(ChangePsdActivity.this)
                                                .setTitle("提示")
                                                .setMessage("新密码设置成功")
                                                .setPositiveButton("好的", null)
                                                .show();
                                    } else {
                                        new AlertDialog.Builder(ChangePsdActivity.this)
                                                .setTitle("提示")
                                                .setMessage("密码输入错误，请重新设置")
                                                .setPositiveButton("好的", null)
                                                .show();
                                        edit_pwdAfter.getText().clear();
                                        edit_pwdAfterAgain.getText().clear();
                                    }
                                }
                                break;
                            default:
                                new AlertDialog.Builder(ChangePsdActivity.this)
                                        .setTitle("提示")
                                        .setMessage("未知错误，请联系管理员"+state+pwdBeginNum+md5pwdAfterAgain)
                                        .setPositiveButton("好的", null)
                                        .show();
                                edit_pwdBegin.getText().clear();
                                break;

                        }
                    }
                    @Override
                    public void onFailure(int errorNo, String strMsg) {
                        super.onFailure(errorNo, strMsg);
                        Toast.makeText(ChangePsdActivity.this, strMsg, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
