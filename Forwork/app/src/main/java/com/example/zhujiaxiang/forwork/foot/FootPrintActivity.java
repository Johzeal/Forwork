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
 * 足迹
 */
public class FootPrintActivity extends AppCompatActivity {
    private WebView webView_footprint;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_footprint);
        webView_footprint = (WebView)findViewById(R.id.webview_footprint);
        webView_footprint.getSettings().setJavaScriptEnabled(true);
        webView_footprint.getSettings().setBuiltInZoomControls(true);
        webView_footprint.loadUrl("http://104.224.185.59/campus/map.html");
        webView_footprint.setWebViewClient(new WebViewClient());
    }
}
