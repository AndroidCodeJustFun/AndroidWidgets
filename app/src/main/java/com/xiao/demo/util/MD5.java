package com.xiao.demo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by xiao on 2017/10/13.
 */

public class MD5 {


	public static String getMD5(byte[] val) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.reset();
			md5.update(val);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] m = md5.digest();// 加密
		return getString(m);
	}

	public static String getMD5(String val) {
		String m = "";
		try {
			m = getMD5(val.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return m;
	}

	public static String getMD5(File file) {
		InputStream fis;
		byte[] buffer = new byte[1024];
		int numRead = 0;
		MessageDigest md5 = null;
		try {
			fis = new FileInputStream(file);
			md5 = MessageDigest.getInstance("MD5");
			while ((numRead = fis.read(buffer)) > 0) {
				md5.update(buffer, 0, numRead);
			}
			fis.close();
			return getString(md5.digest());
		} catch (Exception e) {
			System.out.println("MD5 error");
			return null;
		}

	}

	private static String getString(byte[] b) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			if (Integer.toHexString(0xFF & b[i]).length() == 1)
				sb.append("0").append(Integer.toHexString(0xFF & b[i]));
			else
				sb.append(Integer.toHexString(0xFF & b[i]));
		}
		return sb.toString();
	}

}
