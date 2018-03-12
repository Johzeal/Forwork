package com.example.zhujiaxiang.forwork.tools;

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
 * 我的收藏
 */
public class CollectionActivity extends AppCompatActivity {
    private WebView webView_collection;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        webView_collection = (WebView)findViewById(R.id.webview_collection);
        webView_collection.getSettings().setJavaScriptEnabled(true);
        webView_collection.getSettings().setBuiltInZoomControls(true);
        webView_collection.loadUrl("");
        webView_collection.setWebViewClient(new WebViewClient());
    }
}
