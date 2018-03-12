package com.example.zhujiaxiang.forwork.find;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.zhujiaxiang.forwork.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by zhujiaxiang on 18/3/9.
 */

/**
 * 减压图片
 */
public class HeartsrcActivity extends AppCompatActivity {
    private SimpleDraweeView src_1;
    private SimpleDraweeView src_2;
    private SimpleDraweeView src_3;
    private SimpleDraweeView src_4;
    private SimpleDraweeView src_5;
    private SimpleDraweeView src_6;
    private SimpleDraweeView src_7;
    private SimpleDraweeView src_8;
    private SimpleDraweeView src_9;
    private SimpleDraweeView src_10;
    private SimpleDraweeView src_11;
    private SimpleDraweeView src_12;
    private SimpleDraweeView src_13;
    private SimpleDraweeView src_14;
    private SimpleDraweeView src_15;
    private SimpleDraweeView src_16;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_heartsrc);
        src_1 = (SimpleDraweeView)findViewById(R.id.src_1);
        src_2 = (SimpleDraweeView)findViewById(R.id.src_2);
        src_3 = (SimpleDraweeView)findViewById(R.id.src_3);
        src_4 = (SimpleDraweeView)findViewById(R.id.src_4);
        src_5 = (SimpleDraweeView)findViewById(R.id.src_5);
        src_6 = (SimpleDraweeView)findViewById(R.id.src_6);
        src_7 = (SimpleDraweeView)findViewById(R.id.src_7);
        src_8 = (SimpleDraweeView)findViewById(R.id.src_8);
        src_9 = (SimpleDraweeView)findViewById(R.id.src_9);
        src_10 = (SimpleDraweeView)findViewById(R.id.src_10);
        src_11 = (SimpleDraweeView)findViewById(R.id.src_11);
        src_12 = (SimpleDraweeView)findViewById(R.id.src_12);
        src_13 = (SimpleDraweeView)findViewById(R.id.src_13);
        src_14 = (SimpleDraweeView)findViewById(R.id.src_14);
        src_15 = (SimpleDraweeView)findViewById(R.id.src_15);
        src_16 = (SimpleDraweeView)findViewById(R.id.src_16);

        Uri uri =  Uri.parse("http://www.johzeal.com/kf/img/fresco.jpeg");
        DraweeController controller1 = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        DraweeController controller2 = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        DraweeController controller3 = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        DraweeController controller4 = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        DraweeController controller5 = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        DraweeController controller6 = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        DraweeController controller7 = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        DraweeController controller8 = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        DraweeController controller9 = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        DraweeController controller10 = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        DraweeController controller11 = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        DraweeController controller12 = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        DraweeController controller13 = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        DraweeController controller14 = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        DraweeController controller15 = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        DraweeController controller16 = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        src_1.setController(controller1);
        src_2.setController(controller2);
        src_3.setController(controller3);
        src_4.setController(controller4);
        src_5.setController(controller5);
        src_6.setController(controller6);
        src_7.setController(controller7);
        src_8.setController(controller8);
        src_9.setController(controller9);
        src_10.setController(controller10);
        src_11.setController(controller11);
        src_12.setController(controller12);
        src_13.setController(controller13);
        src_14.setController(controller14);
        src_15.setController(controller15);
        src_16.setController(controller16);

    }

}
