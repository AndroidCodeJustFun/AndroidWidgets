package com.xiao.demo.util;

import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 下载工具类
 */
public class DownloadUtil {

	public static final String TAG = "DownloadUtil";

	static final String DEFAULT_PATH = "/";

	private OnDownLoadFinishedListener onDownLoadFinishedListener = null;

	private File updateDir = null;

	private File updateFile = null;

	private boolean isCreateFileSucess;

	private DownloadUtil() {

	}

	private String fileUrl;

	private String fileName;

	private String savePath;

	private DownloadUtil(Builder builder) {
		this.onDownLoadFinishedListener = builder.onDownLoadFinishedListener;
		if (TextUtils.isEmpty(builder.fileUrl))
			throw new IllegalArgumentException("fileUrl can not be empty");
		this.fileUrl = builder.fileUrl;

		if (TextUtils.isEmpty(builder.fileName)) {
			this.fileName = MD5.getMD5(fileUrl);
		} else this.fileName = builder.fileName;

		this.savePath = builder.savePath;
		Log.e(TAG, "DownloadUtil: fileUrl = " + fileUrl + " fileName = " + fileName + "  savePath = " + savePath);
	}

	private static class FileDownLoadInstance {
		private static DownloadUtil voicePlayUtil = new DownloadUtil();
	}

	public static DownloadUtil getInstance() {
		return FileDownLoadInstance.voicePlayUtil;
	}

	public interface OnDownLoadFinishedListener {
		public String getFilePath();

		public void onComplete(String filePath);
	}

	public void setOnDownLoadFinished(OnDownLoadFinishedListener onDownLoadFinishedListener) {
		this.onDownLoadFinishedListener = onDownLoadFinishedListener;
	}

	private static ExecutorService es;

	public void startDown(String fileUrl, String fileName, String savePath) {
		if (isExists(fileName, savePath)) {
			onDownLoadFinishedListener.onComplete(updateFile.getAbsolutePath());
		} else {
			createFile();
			if (isCreateFileSucess) {
				es = Executors.newFixedThreadPool(10);
				try {
					onDownLoadFinishedListener.onComplete(downResult(fileUrl));
				} catch (Exception e) {
				} finally {
					es.shutdown();
				}
			}
		}
	}

	private String downResult(String fileUrl) throws Exception {
		Future<String> submit = es.submit(new DownCallable(fileUrl));
		return submit.get();
	}

	private class DownCallable implements Callable<String> {
		private String fileUrl;

		public DownCallable(String fileUrl) {
			this.fileUrl = fileUrl;
		}

		@Override
		public String call() throws Exception {
			try {
				URL url = new URL(fileUrl);
				InputStream inputStream;
				OutputStream outputStream;

				HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
				httpURLConnection.setConnectTimeout(15 * 1000);
				httpURLConnection.setReadTimeout(15 * 1000);
				if (httpURLConnection.getResponseCode() != 200)
				// 返回码不等于200 http连接异常 直接返回下载失败
				{
					FileUtil.deleteFile(updateFile.getAbsolutePath());
					return "error";
				}

				inputStream = httpURLConnection.getInputStream();
				outputStream = new FileOutputStream(updateFile.getAbsoluteFile(), false);// 文件存在则覆盖掉

				byte buffer[] = new byte[1024];
				int readsize = 0;
				while ((readsize = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, readsize);
					outputStream.flush();
				}
				if (httpURLConnection != null) {
					httpURLConnection.disconnect();
				}
				inputStream.close();
				outputStream.close();

			} catch (IOException e) {
			}
			return updateFile.getAbsolutePath();
		}

	}

	private boolean isExists(String file_name, String savePath) {
		if (android.os.Environment.MEDIA_MOUNTED.equals(android.os.Environment.getExternalStorageState())) {
			updateDir = new File(savePath);
			if (!updateDir.exists()) {
				updateDir.mkdirs();
			}
			updateFile = new File(updateDir + "/" + file_name);
			boolean exists = updateFile.exists();
			if (exists) // 文件存在 进一步判断文件大小
			{
				long fileSize = FileUtil.getFileSize(updateFile);
				if (fileSize <= 0)  // 文件存在 但大小为空 删除文件   返回false
				{
					updateFile.delete();
					return false;
				} else return true;

			} else {
				return false;
			}
		}
		return false;
	}

	private void createFile() {
		if (android.os.Environment.MEDIA_MOUNTED.equals(android.os.Environment.getExternalStorageState())) {
			isCreateFileSucess = true;
			try {
				updateFile.createNewFile();
			} catch (IOException e) {
				isCreateFileSucess = false;
				e.printStackTrace();
			}
		} else {
			isCreateFileSucess = false;
		}
	}

	public String startDownLoad() {
		if (isExists(fileName, savePath)) {
			onDownLoadFinishedListener.onComplete(updateFile.getAbsolutePath());
			return updateFile.getAbsolutePath();
		} else {
			createFile();
			if (isCreateFileSucess) {
//				new Thread() {
//					@Override
//					public void run() {
//						super.run();
				es = Executors.newFixedThreadPool(5);
				try {
					String result = downResult(fileUrl);
//							return downResult(fileUrl);
					onDownLoadFinishedListener.onComplete(result);
//							updateFile = new File(result);

				} catch (Exception e) {
				} finally {
					es.shutdown();
				}
			}
//				}.start();
//			}
		}
		return null;
	}

	public final static class Builder {

		private OnDownLoadFinishedListener onDownLoadFinishedListener;

		private String fileUrl;

		private String fileName;

		private String savePath;

		public Builder() {
			savePath = DEFAULT_PATH;
		}

		public Builder setFileUrl(String fileUrl) {
			this.fileUrl = fileUrl;
			return this;
		}

		public Builder setFileName(String fileName) {
			this.fileName = fileName;
			return this;
		}


		public Builder setSavePath(String savePath) {
			this.savePath = savePath;
			return this;
		}


		public Builder setOnDownLoadFinishedListener(OnDownLoadFinishedListener onDownLoadFinishedListener) {
			this.onDownLoadFinishedListener = onDownLoadFinishedListener;
			return this;
		}

		public DownloadUtil build() {
			return new DownloadUtil(this);
		}

	}

}
