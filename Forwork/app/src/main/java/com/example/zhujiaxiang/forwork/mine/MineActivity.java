package com.example.zhujiaxiang.forwork.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.zhujiaxiang.forwork.R;
import com.example.zhujiaxiang.forwork.find.FindActivity;
import com.example.zhujiaxiang.forwork.foot.NavActivity;

/**
 * Created by zhujiaxiang on 18/3/9.
 */

public class MineActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton imgBtn_set;
    private Button btn_footgray3;
    private Button btn_findgray3;
    private Button btn_minegray3;
    private LinearLayout layout_aboutus;
    private LinearLayout layout_changepsd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);

        imgBtn_set = (ImageButton)findViewById(R.id.imgBtn_set);
        btn_findgray3 = (Button)findViewById(R.id.btn_findgray3);
        btn_footgray3 = (Button)findViewById(R.id.btn_footblue3);
        btn_minegray3 = (Button)findViewById(R.id.btn_mineblue3);
        layout_aboutus = (LinearLayout)findViewById(R.id.layout_aboutus);
        layout_changepsd = (LinearLayout)findViewById(R.id.layout_changepsd);

        imgBtn_set.setOnClickListener(this);
        btn_findgray3.setOnClickListener(this);
        btn_minegray3.setOnClickListener(this);
        btn_footgray3.setOnClickListener(this);
        layout_changepsd.setOnClickListener(this);
        layout_aboutus.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgBtn_set:
                break;
            case R.id.btn_findgray3:
                Intent intent_find = new Intent(MineActivity.this, FindActivity.class);
                startActivity(intent_find);
                overridePendingTransition(0,0);
                finish();
                break;
            case R.id.btn_footblue3:
                Intent intent_foot = new Intent(MineActivity.this, NavActivity.class);
                startActivity(intent_foot);
                overridePendingTransition(0,0);
                finish();
                break;
            case R.id.btn_mineblue3:
                break;
            case R.id.layout_aboutus:
                new AlertDialog.Builder(MineActivity.this)
                        .setTitle("关于我们")
                        .setIcon(R.mipmap.img_dunheart)
                        .setMessage("所有相关技术由哈尔滨师范大学可信网络与智能计算研究室提供并维护，PanTher研究室拥有最终解释权。")
                        .setPositiveButton("确定",null)
                        .show();
                break;
            case R.id.layout_changepsd:
                break;
        }

    }
}
