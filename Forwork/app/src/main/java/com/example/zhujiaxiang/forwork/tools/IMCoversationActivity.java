package com.example.zhujiaxiang.forwork.tools;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.example.zhujiaxiang.forwork.R;

import io.rong.imlib.model.Conversation;

/**
 * Created by zhujiaxiang on 18/3/9.
 */

public class IMCoversationActivity extends ActionBarActivity {
    /**
     * 目标 Id
     */
    private String mTargetId;

    /**
     * 刚刚创建完讨论组后获得讨论组的id 为targetIds，需要根据 为targetIds 获取 targetId
     */
    private String mTargetIds;

    /**
     * 会话类型
     */
    private Conversation.ConversationType mConversationType;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

        getSupportActionBar().setTitle("聊天");
        getSupportActionBar().setLogo(R.mipmap.img_dunheart);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.img_dunheart);

    }
}
