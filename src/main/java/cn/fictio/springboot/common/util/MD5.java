package cn.fictio.springboot.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

	public static String getMD5(String str){
		
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(str.getBytes());
			byte[] bytes = md5.digest();
			
			StringBuffer sb = new StringBuffer("");
			
			int temp;
			for (int i = 0; i < bytes.length; i++) {
				temp = bytes[i];
				if(temp<0){
					temp += 256;
				}
				if(temp < 16){
					sb.append("0");
				}
				sb.append(Integer.toHexString(temp));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
}
