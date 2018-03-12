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
 * 约图书馆
 */
public class LibraryActivity extends AppCompatActivity {
    private WebView webView_library;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        webView_library = (WebView)findViewById(R.id.webview_library);
        webView_library.getSettings().setJavaScriptEnabled(true);
        webView_library.getSettings().setBuiltInZoomControls(true);
        webView_library.loadUrl("");
        webView_library.setWebViewClient(new WebViewClient());
    }
}
