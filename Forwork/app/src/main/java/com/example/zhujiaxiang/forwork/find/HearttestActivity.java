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

public class HearttestActivity extends AppCompatActivity {
    private WebView webView_hearttest;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hearttest);
        webView_hearttest = (WebView)findViewById(R.id.webview_hearttest);
        webView_hearttest.getSettings().setJavaScriptEnabled(true);
        webView_hearttest.getSettings().setBuiltInZoomControls(true);
        webView_hearttest.loadUrl("http://104.160.41.41/kf/test.html");
        webView_hearttest.setWebViewClient(new WebViewClient());
    }
}
