package com.xiao.demo;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.facebook.common.file.FileUtils;
import com.xiao.demo.base.BaseActivity;
import com.xiao.demo.util.FormatTools;
import com.xiao.demo.util.WebViewCacheUtil;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

import butterknife.BindView;
import okhttp3.OkHttpClient;

/**
 * Created by xiao on 2017/9/12.
 */

public class WebViewActivity extends BaseActivity {

	@BindView(R.id.webview)
	WebView mWebView;

	@BindView(R.id.progressbar)
	ProgressBar mProgressBar;

	private String url;

	private String TYS_SHOP = "http://cms.ddoctor.cn/tyscms/admin.php?r=wechat/DdoctorUser/mallIndexV3&from=patient&userid=10000039&useragent=android&nojump=1";

	private String URL_HFZ = "http://app.crcf.ctvcloud.com/ark/home/news/hotspot_home.shtml";

	private String CHART = "http://www.avi.com.cn/test/test.php?from=singlemessage";

	public static void start(Context context, String url) {
		Intent starter = new Intent(context, WebViewActivity.class);
		starter.putExtra("url", url);
		context.startActivity(starter);
	}

	@Override
	public int layoutRes() {
		return R.layout.activity_webview;
	}

	public void handleIntent() {
		
		Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		Log.e(TAG, "handleIntent: " + extras);
		if (extras != null && extras.isEmpty()) {
			url = extras.getString("url", null);
		} else url = intent.getStringExtra("url");
	}

	@Override
	public void initView() {
		handleIntent();
		url = URL_HFZ;
//		if (url == null) finish();
		initWebView();

	}

	@Override
	public void initData() {

	}


	private void initWebView() {
		mWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null); // 避免页面闪烁
		mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
		mWebView.setHorizontalScrollBarEnabled(false);// 水平不显示
		mWebView.setVerticalScrollBarEnabled(false); // 垂直不显示
		WebSettings settings = mWebView.getSettings();
		settings.setJavaScriptEnabled(true);
		settings.setCacheMode(WebSettings.LOAD_DEFAULT);
		settings.setLoadWithOverviewMode(true);
		settings.setLoadsImagesAutomatically(true);
		settings.setNeedInitialFocus(true);
		// 适应屏幕
		settings.setUseWideViewPort(true);
		settings.setLoadWithOverviewMode(true);

		// localStorage无效的解决方法 保留 DOM Storage 默认false
		settings.setDomStorageEnabled(true);

		settings.setAppCacheMaxSize(1024 * 1024 * 8);
		String appCachePath = getApplicationContext().getCacheDir().getAbsolutePath();
		settings.setAppCachePath(appCachePath);
		settings.setAppCacheEnabled(true);
		settings.setAllowFileAccess(true);

		settings.setBlockNetworkImage(false);
		mWebView.setWebChromeClient(new WebChromeClient());
		settings.setJavaScriptEnabled(true);
		settings.setJavaScriptCanOpenWindowsAutomatically(false);
		ConstraintLayout c;
		mWebView.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
				return super.shouldOverrideUrlLoading(view, request);
			}

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				return super.shouldOverrideUrlLoading(view, url);
			}

			@TargetApi(Build.VERSION_CODES.LOLLIPOP)
			@Override
			public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
				WebResourceResponse webResourceResponse = WebViewCacheUtil.getWebResourceResponse(request.getUrl().toString(), WebViewActivity.this);
				Log.e(TAG, "shouldInterceptRequest: " + request.getUrl() + "  " + webResourceResponse);
				return webResourceResponse;
			}

			@Override
			public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
				Log.e(TAG, "shouldInterceptRequest: " + url);
				if (!TextUtils.isEmpty(url) && !TextUtils.isEmpty(Uri.parse(url).getScheme()) && (url.startsWith("http") || url.startsWith("https")))
//					return getWebResourceResponse(url);
					return WebViewCacheUtil.getWebResourceResponse(url, WebViewActivity.this);
				return null;
			}

			@Override
			public void onPageFinished(WebView view, String url) {
				super.onPageFinished(view, url);
			}

			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				super.onPageStarted(view, url, favicon);
			}

			@Override
			public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
				super.onReceivedError(view, request, error);
			}

			@Override
			public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
				super.onReceivedHttpError(view, request, errorResponse);
			}

			@Override
			public void onScaleChanged(WebView view, float oldScale, float newScale) {
				super.onScaleChanged(view, oldScale, newScale);
			}

		});


		mWebView.setWebChromeClient(new WebChromeClient() {
			@Override
			public void onReceivedTitle(WebView view, String title) {
				setTitle(title);
			}

			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				super.onProgressChanged(view, newProgress);
				mProgressBar.setProgress(newProgress);
			}

			@Override
			public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
				return super.onJsAlert(view, url, message, result);
			}

			@Override
			public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
				return super.onJsConfirm(view, url, message, result);
			}

			@Override
			public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
				return super.onJsPrompt(view, url, message, defaultValue, result);
			}

			@Override
			public boolean onJsBeforeUnload(WebView view, String url, String message, JsResult result) {
				return super.onJsBeforeUnload(view, url, message, result);
			}

			@Override
			public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
				return super.onConsoleMessage(consoleMessage);
			}

			@Override
			public void onConsoleMessage(String message, int lineNumber, String sourceID) {
				super.onConsoleMessage(message, lineNumber, sourceID);
			}
		});

		mWebView.loadUrl(url);

	}

	private WebResourceResponse getWebResourceResponse(String priviteUrl) {
		if (null == Uri.parse(priviteUrl).getLastPathSegment()) {
			return null;
		}

		WebResourceResponse resourceResponse = WebViewCacheUtil.getWebResourceResponse(priviteUrl, WebViewActivity.this);
		if (resourceResponse != null) return resourceResponse;

		String filename = Uri.parse(priviteUrl).getLastPathSegment().trim().toLowerCase();
		String strMd5 = priviteUrl;

		if (filename.contains("image_td.php") || filename.contains(".jpg") || filename.contains(".png")) {
			String filename_ext = ".jpg";
			String contentType = "image/jpg";
			if (filename.contains(".png")) {
				filename_ext = ".png";
				contentType = "image/png";
			}

			File file = new File(strMd5 + filename_ext);
			if (!file.exists()) { // 文件不存在
				try {

					Drawable drawable = getResources().getDrawable(R.mipmap.fox);
					InputStream is = FormatTools.getInstance().Drawable2InputStream(drawable);
					return new WebResourceResponse(contentType, "utf-8", is);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return null;
		}
		return null;
	}

}
