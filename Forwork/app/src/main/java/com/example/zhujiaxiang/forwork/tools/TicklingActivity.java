package com.example.zhujiaxiang.forwork.tools;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.zhujiaxiang.forwork.R;

/**
 * Created by zhujiaxiang on 18/3/9.
 */

/**
 * 意见反馈
 */
public class TicklingActivity extends AppCompatActivity {
    private Button tickling_btnbtn;
    private EditText tickling_edit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickling);
        tickling_btnbtn = (Button)findViewById(R.id.tickling_btnbtn);
        tickling_edit = (EditText)findViewById(R.id.tickling_edit);
        tickling_btnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edit_tickling = tickling_edit.getText().toString();
                if (edit_tickling.equals("")){
                    new AlertDialog.Builder(TicklingActivity.this)
                            .setIcon(R.mipmap.img_heartdun)
                            .setTitle("提醒")
                            .setMessage("反馈不能为空")
                            .setPositiveButton("确定",null)
                            .show();
                }else{
                    new AlertDialog.Builder(TicklingActivity.this)
                            .setIcon(R.mipmap.img_heartdun)
                            .setTitle("提醒")
                            .setMessage("反馈已提交")
                            .setPositiveButton("确定",null)
                            .show();
                }
            }
        });
    }
}


