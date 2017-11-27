package com.xiao.demo.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.webkit.WebResourceResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by xiao on 2017/10/13.
 */

public class WebViewCacheUtil {

	public static final String TAG = "WebViewCacheUtil";

	/**
	 * 根据图片地址把图片缓存到本地
	 *
	 * @param priviteUrl 图片地址
	 * @return WebResourceResponse
	 */
	@SuppressLint("DefaultLocale")
	public static WebResourceResponse getWebResourceResponse(String priviteUrl, Context context) {
		Uri parse = Uri.parse(priviteUrl);
		if (null == parse.getLastPathSegment()) {
			return null;
		}
		Log.e(TAG, "getWebResourceResponse: privateUrl.parse = " + parse);
		String filename = parse.getLastPathSegment().trim().toLowerCase();
		String strMd5 = MD5.getMD5(priviteUrl);
		if (filename.contains("image_td.php") || filename.contains(".jpg") || filename.contains(".png")) {
			String filename_ext = ".jpg";
			String contentType = "image/jpg";
			if (filename.contains(".png")) {
				filename_ext = ".png";
				contentType = "image/png";
			}

			String rootDir = "";
			try {
				if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
					rootDir = context.getApplicationContext().getExternalFilesDir(null).getAbsolutePath();
				}
			} catch (Exception e) {
				rootDir = context.getFilesDir().getAbsolutePath();
			}

			File file = new File(rootDir + "/" + strMd5 + filename_ext);
			if (!file.exists()) { // 文件不存在

				try {
					AsyncCacheUtil build = new AsyncCacheUtil.Builder().setFileUrl(priviteUrl).setFileName(filename).setSavePath(rootDir).build();
					AsyncResult<String> asyncResult = build.startProcess();
					String result = build.endProcess(asyncResult);
					Log.e(TAG, "getWebResourceResponse:   " + result);
					if (result == null || "error".equalsIgnoreCase(result)) {
						Log.e(TAG, "getWebResourceResponse: cache failed result = " + result);
						return null;
					}
					FileInputStream fileinputstream;
					fileinputstream = new FileInputStream(result);
					WebResourceResponse tmpwebresourcerespnose = new WebResourceResponse(contentType, "UTF-8", fileinputstream);
					return tmpwebresourcerespnose;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return getWebResourceResponse(rootDir, strMd5 + filename_ext);
		}
		return null;
	}

	/**
	 * 从本地读取缓图片
	 *
	 * @param filepath 文件路径
	 * @param filename 文件名
	 * @return WebResourceResponse
	 */
	@SuppressLint("NewApi")
	private static WebResourceResponse getWebResourceResponse(String filepath, String filename) {
		String contentType = "image/jpg";
		WebResourceResponse tmpwebresourcerespnose = null;
		if (filename.contains(".png"))
			contentType = "image/png";
		FileInputStream fileinputstream;
		try {
			fileinputstream = new FileInputStream(filepath + "/" + filename);
			Log.e(TAG, "getWebResourceResponse: " + filepath + "/" + filename);
			tmpwebresourcerespnose = new WebResourceResponse(contentType, "UTF-8", fileinputstream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return tmpwebresourcerespnose;
	}

}
