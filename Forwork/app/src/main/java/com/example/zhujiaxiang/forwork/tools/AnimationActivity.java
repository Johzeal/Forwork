package com.example.zhujiaxiang.forwork.tools;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import com.example.zhujiaxiang.forwork.MainActivity;
import com.example.zhujiaxiang.forwork.R;

/**
 * Created by zhujiaxiang on 18/3/7.
 */

public class AnimationActivity extends AppCompatActivity {
    //  变化的ImageView
    private ImageView heart;
    //  Handler实例化
    Handler handler = new Handler();
    //  定义倒计时参数count代表倒计时间
    int count = 4;
    //  定义是否自动跳转，isauto为布尔值类型
    boolean isauto = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        //  初始化
        init();
        //  使用方法透明动画
        alpha(heart);
        //线程使用
        Thread();
    }

    /**
     * 线程机制，实现定时跳转
     */
    private void Thread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = count;
                for (; i > 0; i--) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.sendEmptyMessage(i);
                }
                if (isauto) {
                    handler.sendEmptyMessage(0);
                }
            }
        }).start();
    }
    //  初始化绑定
    private void init() {
        heart = (ImageView) findViewById(R.id.img_heartdun);
    }
    //  跳转下一界面
    public void login(View view) {
        isauto = false;
        Intent intent = new Intent(AnimationActivity.this, MainActivity.class);
        overridePendingTransition(0,0);
        startActivity(intent);
        finish();

    }
    //    透明度动画
    public void alpha(View v) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(4000);
        v.startAnimation(anim);
    }
    //    触屏操作
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return  onSingleTapUp(event);
        //   return super.onTouchEvent(event);
    }

    //   单击触发机制
    private boolean onSingleTapUp(MotionEvent event) {
//        Intent intent = new Intent(AnimationActivity.this, MainActivity.class);
//        startActivity(intent);
//        overridePendingTransition(0,0);
//        finish();
        return true;
    }

    class Handler extends android.os.Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int mm = msg.what;
            if (mm > 0) {
//                test_num.setText(""+mm);
            } else if (mm == 0) {
                View view = new View(AnimationActivity.this);
                login(view);
            }
        }
    }
}
