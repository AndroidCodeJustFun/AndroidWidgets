package com.xiao.demo.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;

/**
 * 文件操作
 */
public class FileUtil {
	/**
	 * 根据文件路径读取文件为字符串
	 *
	 * @param filename
	 * @return
	 */
	public static String readFile(String filename) {
		try {
			FileInputStream stream = new FileInputStream(filename);
			ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
			byte[] b = new byte[1024];
			int n;
			while ((n = stream.read(b)) != -1)
				out.write(b, 0, n);
			stream.close();
			out.close();

			return new String(out.toByteArray(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	/**
	 * 保存图片文件
	 *
	 * @param bm
	 * @param filename
	 * @return
	 */
	public static boolean saveBitmapToFile(Bitmap bm, String filename) {
		File f = new File(filename);
		if (f.exists()) {
			f.delete();
		}

		try {
			FileOutputStream out = new FileOutputStream(f);
			bm.compress(Bitmap.CompressFormat.JPEG, 90, out);
			out.flush();
			out.close();
			return true;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return false;

	}

	/**
	 * 写入文件
	 *
	 * @param filename
	 * @param data
	 * @return
	 */
	public static boolean writeFile(String filename, String data) {
		try {
			FileOutputStream fout = new FileOutputStream(filename);
			fout.write(data.getBytes(), 0, data.getBytes().length);
			fout.close();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * 检测设备中所有存储路径
	 *
	 * @return
	 */
	public static ArrayList<String> getExternalStorageDirectory() {
		String dir = new String();
		ArrayList<String> list = new ArrayList<String>();
		try {
			Runtime runtime = Runtime.getRuntime();
			Process proc = runtime.exec("mount");
			InputStream is = proc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			String line;
			BufferedReader br = new BufferedReader(isr);
			while ((line = br.readLine()) != null) {
				if (line.contains("secure")) {
					continue;
				}
				if (line.contains("asec")) {
					continue;
				}
				if (line.contains("fat")) {
					String columns[] = line.split(" ");
					if (columns != null && columns.length > 1) {
						dir = dir.concat(columns[1]);
						list.add(columns[1]);
					}
				} else if (line.contains("fuse")) {
					String columns[] = line.split(" ");
					if (columns != null && columns.length > 1) {
						list.add(columns[1]);
					}
				}
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		return list;
	}

	public static boolean isFileExist(String fileUrl) {
		if (TextUtils.isEmpty(fileUrl)) {
			return false;
		}
		File file = new File(fileUrl);
		return file.exists();
	}

	/**
	 * 读取文件转为string
	 *
	 * @param @param  fa
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String getJsonInfo(File fa) {
		try {
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fa)));
			String temp = null;
			while ((temp = br.readLine()) != null) {
				sb.append(temp);
			}
			br.close();
			return sb.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取文件名
	 *
	 * @param @param  filepaht
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String getFileName(String filepaht) {
		if (TextUtils.isEmpty(filepaht)) {
			return "tmp";
		}
		int index = filepaht.indexOf("?authorization");
		if (index != -1) {
			filepaht = filepaht.substring(0, index);
		}
		return filepaht.substring(filepaht.lastIndexOf("/") + 1, filepaht.length());
	}

	/**
	 * 根据文件绝对路径获取文件名称
	 *
	 * @return
	 */
	// public static String getFileName(String filePath)
	// {
	// if (StringUtils.isBlank(filePath)) return "";
	// return filePath.substring(filePath.lastIndexOf(File.separator) + 1);
	// }
	public static long getLastModify(String fileUrl) {
		File file = new File(fileUrl);
		if (!file.exists()) {
			return 0;
		} else {
			return file.lastModified();
		}

	}

	/**
	 * 复制文件到指定目录下
	 *
	 * @param fromFile
	 * @param toFile
	 * @return
	 */
	public static boolean copy2SD(String fromFile, String toFile) {
		try {
			InputStream fosfrom = new FileInputStream(fromFile);
			OutputStream fosto = new FileOutputStream(toFile);
			byte bt[] = new byte[1024];
			int c;
			while ((c = fosfrom.read(bt)) > 0) {
				fosto.write(bt, 0, c);
			}
			fosfrom.close();
			fosto.close();
			return true;

		} catch (Exception ex) {
			return false;
		}
	}

	/**
	 * 根据文件路径与文件名删除文件
	 *
	 * @param path
	 * @param fileName
	 */
	public static void deleteFile(String path, String fileName) {
		File file = new File(path, fileName);
		if (file.exists() && file.isFile()) {
			file.delete();
		}
	}

	/**
	 * 根据文件路径删除文件
	 *
	 * @param path
	 */
	public static void deleteFile(String path) {
		File file = new File(path);
		if (file.exists() && file.isFile()) {
			file.delete();
		}
	}

	/**
	 * 将文件数组排序，目录放在上面，文件在下面
	 *
	 * @param file
	 * @return
	 */
	public static File[] sort(File[] file) {
		ArrayList<File> list = new ArrayList<File>();
		// 放入所有目录
		for (File f : file) {
			if (f.isDirectory()) {
				list.add(f);
			}
		}
		// 放入所有文件
		for (File f : file) {
			if (f.isFile()) {
				list.add(f);
			}
		}
		return list.toArray(new File[file.length]);
	}

	/**
	 * 删除文件夹
	 *
	 * @param @param filepath
	 * @return void
	 * @throws
	 */
	public static void deleteFolder(String filepath) {
		File file = new File(filepath);
		if (file.exists()) {
			if (file.isDirectory()) {
				File[] listFiles = file.listFiles();
				for (File f : listFiles) {
					deleteFolder(f.getAbsolutePath());
				}
				file.delete();
			} else {
				file.delete();
			}
		}
	}

	/**
	 * * 清除本应用内部缓存(/data/data/com.xxx.xxx/cache)
	 *
	 * @param context
	 */
	public static void cleanInternalCache(Context context) {
		deleteFilesByDirectory(context.getCacheDir());
	}

	/**
	 * * 清除本应用所有数据库(/data/data/com.xxx.xxx/databases)
	 *
	 * @param context
	 */
	public static void cleanDatabases(Context context) {
		deleteFilesByDirectory(new File("/data/data/" + context.getPackageName() + "/databases"));
	}

	/**
	 * * 清除本应用SharedPreference(/data/data/com.xxx.xxx/shared_prefs)
	 *
	 * @param context
	 */
	public static void cleanSharedPreference(Context context) {
		deleteFilesByDirectory(new File("/data/data/" + context.getPackageName() + "/shared_prefs"));
	}

	/**
	 * 按名字清除本应用数据库 * context *
	 *
	 * @param dbName
	 */
	public static void cleanDatabaseByName(Context context, String dbName) {
		context.deleteDatabase(dbName);
	}

	/**
	 * * 清除/data/data/com.xxx.xxx/files下的内容 * *
	 *
	 * @param context
	 */
	public static void cleanFiles(Context context) {
		deleteFilesByDirectory(context.getFilesDir());
	}

	/**
	 * * 清除外部cache下的内容(/mnt/sdcard/android/data/com.xxx.xxx/cache)
	 *
	 * @param context
	 */
	public static void cleanExternalCache(Context context) {
		if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
			deleteFilesByDirectory(context.getExternalCacheDir());
		}
	}

	/**
	 * * 清除自定义路径下的文件，使用需小心，请不要误删。而且只支持目录下的文件删除
	 *
	 * @param filePath
	 */
	public static void cleanCustomCache(String filePath) {
		File file = new File(filePath);
		if (null != file && file.exists()) {
			deleteFilesByDirectory(file);
		}

	}

	/**
	 * 获取指定文件夹大小 long 值
	 *
	 * @param f
	 * @return
	 */
	public static long getFileSize(File f) {
		long size = 0;
		if (!f.exists()) return 0;
		if (f.isFile()) return f.length();
		File flist[] = f.listFiles();
		if (flist != null && flist.length > 0) {
			for (int i = 0; i < flist.length; i++) {
				if (flist[i].isDirectory()) {
					size = size + getFileSize(flist[i]);
				} else {
					size = size + flist[i].length();
				}
			}
		}
		return size;
	}

	/**
	 * 清除本应用所有的数据 * @param context * @param filepath
	 */
	public static void cleanApplicationData(Context context, String... filepath) {
		cleanInternalCache(context);
		cleanExternalCache(context);
		cleanDatabases(context);
		cleanSharedPreference(context);
		cleanFiles(context);
		for (String filePath : filepath) {
			cleanCustomCache(filePath);
		}
	}

	/**
	 * * 删除方法 这里只会删除某个文件夹下的文件，如果传入的directory是个文件，将不做处理 *
	 *
	 * @param directory
	 */
	private static void deleteFilesByDirectory(File directory) {
		if (null != directory && directory.exists() && directory.isDirectory()) {
			File[] listFiles = directory.listFiles();
			if (listFiles.length > 0) {
				for (File item : listFiles) {
					item.delete();
				}
			} else {
				directory.delete();
			}

		}
	}

	/**
	 * 判断SD是否可以
	 *
	 * @return
	 */
	public static boolean isSdcardExist() {
		if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
			return true;
		}
		return false;
	}

	/**
	 * 创建根目
	 *
	 * @param path 目录路径
	 */
	public static void createDirFile(String path) {
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}
	}

	/**
	 * 创建文件
	 *
	 * @param path 文件路径
	 * @return 创建的文件
	 */
	public static File createNewFile(String path) {
		File file = new File(path);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				return null;
			}
		}
		return file;
	}

	/**
	 * 删除文件
	 *
	 * @param folderPath 文件夹的路径
	 */
	public static void delFolder(String folderPath) {
		delAllFile(folderPath);
		String filePath = folderPath;
		filePath = filePath.toString();
		java.io.File myFilePath = new java.io.File(filePath);
		myFilePath.delete();
	}

	/**
	 * 删除文件
	 *
	 * @param path 文件的路径
	 */
	public static void delAllFile(String path) {
		File file = new File(path);
		if (!file.exists()) {
			return;
		}
		if (!file.isDirectory()) {
			return;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);
				delFolder(path + "/" + tempList[i]);
			}
		}
	}

	/**
	 * 获取文件的Uri
	 *
	 * @param path 文件的路径
	 * @return
	 */
	public static Uri getUriFromFile(String path) {
		File file = new File(path);
		return Uri.fromFile(file);
	}

	/**
	 * 换算文件大小
	 *
	 * @param size
	 * @return
	 */
	public static String formatFileSize(long size) {
		DecimalFormat df = new DecimalFormat("#.00");
		String fileSizeString = "未知大小";
		if (size < 1024) {
			fileSizeString = df.format((double) size) + "B";
		} else if (size < 1048576) {
			fileSizeString = df.format((double) size / 1024) + "K";
		} else if (size < 1073741824) {
			fileSizeString = df.format((double) size / 1048576) + "M";
		} else {
			fileSizeString = df.format((double) size / 1073741824) + "G";
		}
		return fileSizeString;
	}

	/**
	 * 获取根目录
	 */
	public static String getRootDir() {
		return Environment.getExternalStorageDirectory().getAbsolutePath();
	}

	/**
	 * 使用当前时间戳拼接一个文件名
	 *
	 * @return
	 */
	public static String getFileName() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_SS");
		String fileName = format.format(new Timestamp(System.currentTimeMillis()));
		return fileName;
	}

	/**
	 * 获取文件扩展名
	 *
	 * @param fileName
	 * @return
	 */
	public static String getFileFormat(String fileName) {
		if (TextUtils.isEmpty(fileName)) return "";

		int point = fileName.lastIndexOf('.');
		return fileName.substring(point + 1);
	}

	/**
	 * 判断sd卡是否存在
	 *
	 * @return
	 */
	public static boolean ExistSDCard() {
		if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)) {
			return true;
		} else return false;
	}

	/**
	 * 创建文件
	 *
	 * @param dir
	 */
	public static void createDir(String dir) {
		String sdpath = getRootDir();
		File destDir = new File(sdpath + dir);
		if (!destDir.exists()) {
			destDir.mkdirs();
		}
	}

	/**
	 * 得到绝对路径
	 *
	 * @param dir
	 * @return
	 */
	public static String getgetAbsoluteDir(String dir) {
		return getRootDir() + dir;

	}

	/**
	 * 文件转byte
	 *
	 * @param f
	 * @return
	 */
	public static byte[] getBytesFromFile(File f) {
		if (f == null) {
			return null;
		}
		try {
			FileInputStream stream = new FileInputStream(f);
			ByteArrayOutputStream out = new ByteArrayOutputStream(1000);
			byte[] b = new byte[1000];
			int n;
			while ((n = stream.read(b)) != -1)
				out.write(b, 0, n);
			stream.close();
			out.close();
			return out.toByteArray();
		} catch (IOException e) {
		}
		return null;
	}

	public static String getFromAssets(Resources res, String fileName) {
		try {
			InputStreamReader inputReader = new InputStreamReader(res.getAssets().open(fileName));
			BufferedReader bufReader = new BufferedReader(inputReader);
			String line = "";
			String Result = "";
			while ((line = bufReader.readLine()) != null)
				Result += line;
			return Result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static class FileSortUtil {
		/**
		 * 按大小
		 *
		 * @param @param fliePath
		 * @return void
		 * @throws
		 */
		public static void orderByLength(List<File> files) {
			Collections.sort(files, new Comparator<File>() {
				public int compare(File f1, File f2) {
					long diff = f1.length() - f2.length();
					if (diff > 0) return 1;
					else if (diff == 0) return 0;
					else return -1;
				}

				public boolean equals(Object obj) {
					return true;
				}
			});
		}

		/**
		 * 按name
		 *
		 * @param @param fliePath
		 * @return void
		 * @throws
		 */
		public static void orderByName(List<File> files) {
			Collections.sort(files, new Comparator<File>() {
				public int compare(File o1, File o2) {
					if (o1.isDirectory() && o2.isFile()) return -1;
					if (o1.isFile() && o2.isDirectory()) return 1;
					return o1.getName().compareTo(o2.getName());
				}
			});
		}

		/**
		 * 按日期
		 *
		 * @param @param fliePath
		 * @return void
		 * @throws
		 */
		public static void orderByDate(List<File> files) {
			Collections.sort(files, new Comparator<File>() {
				public int compare(File f1, File f2) {
					long diff = f1.lastModified() - f2.lastModified();
					if (diff > 0) return 1;
					else if (diff == 0) return 0;
					else return -1;
				}

				public boolean equals(Object obj) {
					return true;
				}
			});
		}
	}
}
