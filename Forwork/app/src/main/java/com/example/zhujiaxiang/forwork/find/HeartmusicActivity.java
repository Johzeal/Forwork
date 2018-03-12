package com.example.zhujiaxiang.forwork.find;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.zhujiaxiang.forwork.R;

/**
 * Created by zhujiaxiang on 18/3/9.
 */

/**
 * 减压音乐
 */

public class HeartmusicActivity extends AppCompatActivity {
    private WebView webView_heartmusic;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heartmusic);
        webView_heartmusic = (WebView)findViewById(R.id.webview_heartmusic);
        webView_heartmusic.getSettings().setJavaScriptEnabled(true);
        webView_heartmusic.getSettings().setBuiltInZoomControls(true);
        webView_heartmusic.loadUrl("");
        webView_heartmusic.setWebViewClient(new WebViewClient());

    }
}
