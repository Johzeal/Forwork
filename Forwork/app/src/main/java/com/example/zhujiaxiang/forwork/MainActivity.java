package com.example.zhujiaxiang.forwork;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zhujiaxiang.forwork.find.FindActivity;
import com.example.zhujiaxiang.forwork.tools.Md5Activity;

import org.json.JSONException;
import org.json.JSONObject;
import org.kymjs.kjframe.KJHttp;
import org.kymjs.kjframe.http.HttpCallBack;
import org.kymjs.kjframe.http.HttpConfig;
import org.kymjs.kjframe.http.HttpParams;

public class MainActivity extends AppCompatActivity {

//    将Md5Activity实例化
    Md5Activity md5Activity = new Md5Activity();
//    定义各个控件以及变量
    private EditText mEditUsername;
    private EditText mEditPassword;
    private String state = null;
    private CheckBox mCheckBox;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;
    private boolean mIsRemember;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  初始化
        init();
        //  登录匹配
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = mEditUsername.getText().toString();
                final String password = mEditPassword.getText().toString();
                final String md5pwd = md5Activity.encode(password);
                //  将KJHttp框架里关键类HJhttp实例化
                KJHttp kjHttp = new KJHttp();
                //  定义params存储数据
                HttpParams params = new HttpParams();
                //  定义缓存时间
                HttpConfig httpConfig = new HttpConfig();
                httpConfig.cacheTime = 0;
                //  将密码进行md5加密，与数据库中注册时的md5加密后的密码匹配
                params.put("stuNum", username);
                params.put("password", md5pwd);
                //  此处进行POST传输
                kjHttp.post("http://69.171.68.121/jy/php/sign.php", params, new HttpCallBack() {
                    @Override
                    public void onSuccess(String t) {
                        super.onSuccess(t);
                        //JSON解析获得键值
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(t);
                            state = jsonObject.get("state").toString();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        /**
                         * 如果用户名正确传递用户名到管理器并储存用户名、密码，并且如果CheckBox是勾选状态就将用户名
                         * 保存，随后跳转。（此处未知错误：不知在清除后台程序时能否保存用户名密码）
                         * 如果用户名密码错误则弹窗提示
                         */
                        if (state.equals("true")) {
                            mEditor = mPreferences.edit();
                            mEditor.putString("account", username);
                            if (mCheckBox.isChecked()) {
                                mEditor.putBoolean("remember_password", true);
                                mEditor.putString("password", password);
                            } else {
                                mEditor.putString("password", null);
                                mEditor.putBoolean("remember_password", false);
                            }
                            mEditor.commit();
                            Intent intent = new Intent(MainActivity.this, FindActivity.class);
                            startActivity(intent);
                            finish();

                        } else {
                            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                            dialog.setTitle("提示");
                            dialog.setMessage("用户名或密码错误");
                            dialog.setPositiveButton("好的", null);
                            dialog.show();

                        }

                    }
                    @Override
                    public void onFailure(int errorNo, String strMsg) {
                        super.onFailure(errorNo, strMsg);
                        Toast.makeText(MainActivity.this, strMsg, Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
    //  初始化
    private void init() {
        //  绑定用户名EditText
        mEditUsername = (EditText) findViewById(R.id.edit_login_usename);
        //  绑定密码EditText
        mEditPassword = (EditText) findViewById(R.id.edit_login_password);
        //  选择框
        mCheckBox = (CheckBox) findViewById(R.id.remember_pass);
        //  定义Perference
        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //  得到CheckBox中初始化为false
        mIsRemember = mPreferences.getBoolean("remember_password", false);
        String account = mPreferences.getString("account", "");
        mEditUsername.setText(account);
        if (mIsRemember) {
            String password = mPreferences.getString("password", "");
            mEditPassword.setText(password);
            mCheckBox.setChecked(true);
        }
        //  绑定登录Button
        mButton = (Button) findViewById(R.id.login_btn);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, FindActivity.class);
        context.startActivity(intent);
    }
}
