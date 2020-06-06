package com.doing.parse.dao;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {
	public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		 //确定计算方法
		   MessageDigest md5=MessageDigest.getInstance("MD5");
		 //加密后的字符串
		 byte[] newstr=md5.digest(str.getBytes("utf-8"));
	        StringBuffer hexValue = new StringBuffer();
	        for (int i = 0; i < newstr.length; i++) {
	            int val = ((int) newstr[i]) & 0xff;
	            if (val < 16) {
	                hexValue.append("0");
	            }
	            hexValue.append(Integer.toHexString(val));
	        }
	        return hexValue.toString();
  }
  public void testMd5() throws NoSuchAlgorithmException, UnsupportedEncodingException{
	  String value=Md5.EncoderByMd5("hahahahahah");
	  System.out.println(value);
  }
}
