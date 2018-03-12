package com.example.zhujiaxiang.forwork.foot;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.zhujiaxiang.forwork.R;

/**
 * Created by zhujiaxiang on 18/3/8.
 */

/**
 * 天气预测
 */
public class WeatherActivity extends NavActivity {
    private WebView webView_weather;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        webView_weather = (WebView)findViewById(R.id.webview_weather);
        webView_weather.getSettings().setJavaScriptEnabled(true);
        webView_weather.getSettings().setBuiltInZoomControls(true);
        webView_weather.loadUrl("http://104.160.41.41/kf/tianqi.html");
        webView_weather.setWebViewClient(new WebViewClient());
    }
}
