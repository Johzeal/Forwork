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
 * 减压文章
 */
public class HeartessayActivity extends AppCompatActivity {
    private WebView webView_heartessay;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_essay);
        webView_heartessay = (WebView)findViewById(R.id.webview_heartessay);
        webView_heartessay.getSettings().setJavaScriptEnabled(true);
        webView_heartessay.getSettings().setBuiltInZoomControls(true);
        webView_heartessay.loadUrl("http://104.224.190.115/jy/article.html");
        webView_heartessay.setWebViewClient(new WebViewClient());

    }
}
