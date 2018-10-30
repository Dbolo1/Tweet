package com.bolo1.tweet_app.ui.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.bolo1.tweet_app.R;
import com.bolo1.tweet_app.ui.uitls.ConstantValue;
import com.bolo1.tweet_app.ui.uitls.LogUtils;
import com.bolo1.tweet_app.ui.uitls.Sputil;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class NewsDesActivity extends AppCompatActivity {

    @InjectView(R.id.wv_webview)
    public  WebView webView;



    @InjectView(R.id.pb_web_process)
    public ProgressBar pb_web_process;
    private static final String tag = "NewsDetailActivity";
    private int fontType;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去标题
        setTheme(R.style.AppTheme);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.news_des_layout);
        initView();

    }



    private void initView() {
        ButterKnife.inject(this);
        String mUrl = getIntent().getStringExtra(ConstantValue.NEWS_DES_URL);
        LogUtils.e("wen url ="+mUrl);
        webView.loadUrl(mUrl);
        pb_web_process.setMax(100);
        WebSettings webSetting = webView.getSettings();
        webSetting.setBuiltInZoomControls(true);//缩放按钮
        webSetting.setUseWideViewPort(true);//双击缩放
        webSetting.setJavaScriptEnabled(true);
        webSetting.setAppCacheEnabled(true);
        webSetting.setDomStorageEnabled(true);
        webSetting.supportMultipleWindows();
        webSetting.setAllowContentAccess(true);
        webSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSetting.setUseWideViewPort(true);
        webSetting.setLoadWithOverviewMode(true);
        webSetting.setSavePassword(true);
        webSetting.setSaveFormData(true);
        webSetting.setJavaScriptCanOpenWindowsAutomatically(true);
        webSetting.setLoadsImagesAutomatically(true);
        webView.setWebChromeClient(new WebChromeClient());//这行最好不要丢掉
        //----------


        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                pb_web_process.setVisibility(View.VISIBLE);
                super.onPageStarted(view, url, favicon);
                Log.d(tag, "开始加网页");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.d(tag, "网页加载完成");

            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Log.d(tag, "跳转url" + request.toString());
                view.loadUrl(request.toString());
                return true;

            }

//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                return super.shouldOverrideUrlLoading(view, url);
////            }
        });
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                //进度的加载
                pb_web_process.setProgress(newProgress);
                if (newProgress == 100) {
                    pb_web_process.setVisibility(View.INVISIBLE);
                }
                Log.d(tag, "当前进度" + newProgress);
                super.onProgressChanged(view, newProgress);
            }
        });


    }



    private int TempFont;

    /**
     * 显示选择字体窗口
     */
    private void showChooseDialog() {

        String[] FontSize = new String[]{
                "超大字体", "大字体",
                " 正常字体 ", "小字体", " 超小字体 ",
        };
        int fontType = Sputil.getInt(this, ConstantValue.FONT_SIZE, 2);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.SETTING_TYPESIZE);
        builder.setSingleChoiceItems(FontSize, fontType, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TempFont = which;
            }
        });


        builder.setNegativeButton(R.string.CANCLE, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton(R.string.CONFIRM, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                WebSettings webSetting = webView.getSettings();
//                SMALLEST(50),
//                        SMALLER(75),
//                        NORMAL(100),
//                        LARGER(150),
//                        LARGEST(200);
                //在这记录字体，并更改webview字体
                Sputil.putInt(getApplicationContext(), ConstantValue.FONT_SIZE, TempFont);
                switch (TempFont) {
                    case 0:
//                        webSetting.setTextSize(WebSettings.TextSize.LARGER);
                        webSetting.setTextZoom(200);
                        break;
                    case 1:
                        webSetting.setTextZoom(150);
                        break;
                    case 2:
                        webSetting.setTextZoom(100);
                        break;
                    case 3:
                        webSetting.setTextZoom(75);
                        break;
                    case 4:
                        webSetting.setTextZoom(50);
                        break;

                }
            }
        });
        builder.show();
    }



}
