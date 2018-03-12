package com.example.zhujiaxiang.forwork.foot;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.zhujiaxiang.forwork.R;

/**
 * Created by zhujiaxiang on 18/3/8.
 */

/**
 * 健康建议
 */
public class HealthActivity extends AppCompatActivity {
    private WebView webView_health;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
        webView_health = (WebView)findViewById(R.id.webview_health);
        webView_health.getSettings().setJavaScriptEnabled(true);
        webView_health.getSettings().setBuiltInZoomControls(true);
        webView_health.loadUrl("http://104.160.41.41/kf/health.html");
        webView_health.setWebViewClient(new WebViewClient());

    }
}
