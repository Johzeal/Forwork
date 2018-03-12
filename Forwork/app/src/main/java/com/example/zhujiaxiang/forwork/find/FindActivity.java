package com.example.zhujiaxiang.forwork.find;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.zhujiaxiang.forwork.R;
import com.example.zhujiaxiang.forwork.foot.NavActivity;
import com.example.zhujiaxiang.forwork.mine.MineActivity;

/**
 * Created by zhujiaxiang on 18/3/8.
 */

public class FindActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtn_foot;
    private Button mBtn_mine;
    private ImageButton mImg_hearttest;
    private ImageButton mImg_heartdoc;
    private ImageButton mImg_teacher;
    private ImageButton mImg_sport;
    private ImageButton mImg_library;
    private ImageButton mImg_food;
    private ImageButton mImg_ktv;
    private ImageButton mImg_game;
    private ImageButton mImg_movie;
    private ImageButton mImg_heartessay;
    private ImageButton mImg_heartmusic;
    private ImageButton mImg_heartsrc;

//    private static final String token1 = "Wf4Ilpnn9SfZxiJ6ElJ/ykKb/grcFQmBCKFvf9YxDtAwOeuuKiCTfkyJ8Gev3msLIVH4wvARGaE=";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        //  初始化
        init();
        //  点击事件
        click();


    }

    //  初始化
    private void init() {
        mBtn_foot = (Button) findViewById(R.id.btn_footgray1);
        mBtn_mine = (Button) findViewById(R.id.btn_minegray1);
        mImg_hearttest = (ImageButton) findViewById(R.id.imgBtn_hearttest);
        mImg_heartdoc = (ImageButton) findViewById(R.id.imgBtn_heartdoc);
        mImg_teacher = (ImageButton) findViewById(R.id.imgBtn_teacher);
        mImg_sport = (ImageButton) findViewById(R.id.imgBtn_sport);
        mImg_library = (ImageButton) findViewById(R.id.imgBtn_library);
        mImg_food = (ImageButton) findViewById(R.id.imgBtn_food);
        mImg_ktv = (ImageButton) findViewById(R.id.imgBtn_ktv);
        mImg_game = (ImageButton) findViewById(R.id.imgBtn_game);
        mImg_movie = (ImageButton) findViewById(R.id.imgBtn_movie);
        mImg_heartessay = (ImageButton) findViewById(R.id.imgBtn_heartessay);
        mImg_heartmusic = (ImageButton) findViewById(R.id.imgBtn_heartmusic);
        mImg_heartsrc = (ImageButton) findViewById(R.id.imgBtn_heartsrc);
    }

    //  点击时间
    private void click() {
        mBtn_foot.setOnClickListener(this);
        mBtn_mine.setOnClickListener(this);
        mImg_hearttest.setOnClickListener(this);
        mImg_heartdoc.setOnClickListener(this);
        mImg_teacher.setOnClickListener(this);
        mImg_sport.setOnClickListener(this);
        mImg_library.setOnClickListener(this);
        mImg_food.setOnClickListener(this);
        mImg_ktv.setOnClickListener(this);
        mImg_game.setOnClickListener(this);
        mImg_movie.setOnClickListener(this);
        mImg_heartessay.setOnClickListener(this);
        mImg_heartmusic.setOnClickListener(this);
        mImg_heartsrc.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgBtn_hearttest:
                Intent intent_hearttest = new Intent(FindActivity.this, HearttestActivity.class);
                startActivity(intent_hearttest);
                break;
            case R.id.imgBtn_heartdoc:
                break;
            case R.id.imgBtn_teacher:
                Intent intent_teacher = new Intent(Intent.ACTION_DIAL);
                Uri uri_teacher = Uri.parse("tel:" + "18800480735");
                intent_teacher.setData(uri_teacher);
                startActivity(intent_teacher);
                break;
            case R.id.imgBtn_sport:
                break;
            case R.id.imgBtn_movie:
                break;
            case R.id.imgBtn_game:
                break;
            case R.id.imgBtn_food:
                break;
            case R.id.imgBtn_library:
                Intent intent_library = new Intent(FindActivity.this, LibraryActivity.class);
                startActivity(intent_library);
                break;
            case R.id.imgBtn_ktv:
                break;
            case R.id.imgBtn_heartmusic:
                Intent intent_heartmusic = new Intent(FindActivity.this, HeartmusicActivity.class);
                startActivity(intent_heartmusic);
                break;
            case R.id.imgBtn_heartessay:
                Intent intent_heartessay = new Intent(FindActivity.this, HeartessayActivity.class);
                startActivity(intent_heartessay);
                break;
            case R.id.imgBtn_heartsrc:
                Intent intent_heartsrc = new Intent(FindActivity.this, HeartsrcActivity.class);
                startActivity(intent_heartsrc);
                break;
            case R.id.btn_footgray1:
                Intent intent_foot = new Intent(FindActivity.this, NavActivity.class);
                startActivity(intent_foot);
                overridePendingTransition(0, 0);
                finish();
                break;
            case R.id.btn_minegray1:
                Intent intent_mine = new Intent(FindActivity.this, MineActivity.class);
                startActivity(intent_mine);
                overridePendingTransition(0, 0);
                finish();
                break;

        }
    }
}
