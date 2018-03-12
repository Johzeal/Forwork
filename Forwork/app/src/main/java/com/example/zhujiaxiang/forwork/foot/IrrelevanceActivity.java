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
 * 离群偏离度
 */
public class IrrelevanceActivity extends AppCompatActivity {
    private WebView webView_irrelevance;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_irrelevance);
        webView_irrelevance.getSettings().setJavaScriptEnabled(true);
        webView_irrelevance.getSettings().setBuiltInZoomControls(true);
        webView_irrelevance = (WebView)findViewById(R.id.webview_irrlevance);
        webView_irrelevance.loadUrl("");
        webView_irrelevance.setWebViewClient(new WebViewClient());

    }
}
