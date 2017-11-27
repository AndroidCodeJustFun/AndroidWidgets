package com.xiao.demo.util;


import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 同步缓存 并返回存储地址
 */
public class AsyncCacheUtil implements AsyncProcess<String> {

	public static final String TAG = "DownloadUtil";

	static final String DEFAULT_PATH = "/";

	private File updateFile = null;

	private boolean isCreateFileSucess;

	private String fileUrl;

	private ExecutorService es;

	private String fileName;

	private String savePath;

	private Callable<String> callable;

	private AsyncCacheUtil(Builder builder) {
		if (builder.fileUrl == null)
			throw new IllegalArgumentException("fileUrl can not be empty");
		this.fileUrl = builder.fileUrl;

		if (builder.fileName == null) {
			this.fileName = fileUrl;
		} else this.fileName = builder.fileName;

		this.savePath = builder.savePath;
		callable = builder.callable != null ? builder.callable : new DownCallable();
		es = Executors.newFixedThreadPool(5);
	}

	@Override
	public AsyncResult<String> startProcess() throws Exception {
		System.out.println("startProcess.[callable] " + fileUrl + " " + fileName);
		Log.e(TAG, "startProcess: " + fileUrl + " " + fileName);

		AsyncResultImpl<String> asyncResult = new AsyncResultImpl<>();

		try {
			if (isExists(fileName, savePath)) {
				asyncResult.setResult(updateFile.getAbsolutePath());
			} else {
				createFile();
				if (isCreateFileSucess) {
					new Thread(() -> {
						try {
							asyncResult.setResult(es.submit(callable).get());
						} catch (InterruptedException e) {
							e.printStackTrace();
							asyncResult.setException(e);
						} catch (ExecutionException e) {
							e.printStackTrace();
							asyncResult.setException(e);
						}
					}).start();
				} else {
					asyncResult.failed("create file failed");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			asyncResult.setException(e);
		}
		return asyncResult;
	}

	@Override
	public String endProcess(AsyncResult<String> asyncResult) throws InterruptedException, ExecutionException {
		if (!asyncResult.isComplete())
			asyncResult.waitUtilFinish();
		if (asyncResult.isComplete() && es != null) {
			es.shutdown();
		}
		Log.e(TAG, "endProcess: " + asyncResult.getResult());
		return asyncResult.getResult();
	}

	private class DownCallable implements Callable<String> {

		public DownCallable() {
		}

		@Override
		public String call() throws IOException {
			try {
				URL url = new URL(fileUrl);
				InputStream inputStream;
				OutputStream outputStream;

				HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
				httpURLConnection.setConnectTimeout(15 * 1000);
				httpURLConnection.setReadTimeout(15 * 1000);
				Log.e(TAG, "call: " + httpURLConnection.getResponseCode() + "  " + httpURLConnection.getResponseMessage());
				if (httpURLConnection.getResponseCode() != 200)
				// 返回码不等于200 http连接异常 直接返回下载失败
				{
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
				throw e;
			}
			return updateFile.getAbsolutePath();
		}

	}

	private boolean isExists(String file_name, String savePath) {
		File updateDir = new File(savePath);
		if (!updateDir.exists()) {
			updateDir.mkdirs();
		}
		updateFile = new File(updateDir + "/" + file_name);
		if (updateFile.exists()) // 文件存在 进一步判断文件大小
		{
			if (updateFile.getTotalSpace() <= 0)  // 文件存在 但大小为空 删除文件   返回false
			{
				updateFile.delete();
			} else return true;
		}
		return false;
	}

	private void createFile() {
		isCreateFileSucess = true;
		try {
			updateFile.createNewFile();
		} catch (IOException e) {
			isCreateFileSucess = false;
			e.printStackTrace();
		}
	}

	public final static class Builder {

		private String fileUrl;

		private String fileName;

		private String savePath;

		private Callable<String> callable;

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

		public Builder withCallable(Callable<String> callable) {
			this.callable = callable;
			return this;
		}

		public AsyncCacheUtil build() {
			return new AsyncCacheUtil(this);
		}

	}

}
