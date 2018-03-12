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
 * 数据统计
 */

public class DataActivity extends AppCompatActivity {
    private WebView webView_data;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        webView_data = (WebView)findViewById(R.id.webview_data);
        webView_data.getSettings().setJavaScriptEnabled(true);
        webView_data.getSettings().setBuiltInZoomControls(true);
        webView_data.loadUrl("http://104.160.41.41/kf/statistic.html");
        webView_data.setWebViewClient(new WebViewClient());

    }
}
