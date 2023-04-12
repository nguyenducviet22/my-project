package util;

import java.security.MessageDigest;

import org.apache.tomcat.util.codec.binary.Base64;

public class Encoding {
	public static String encodeSHA1(String str) {
		String salt = "hgfjhfhgdgfhgj";
		String result = null;
		
		str = str + salt;
		try {
			byte[] dataBytes = str.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			result = Base64.encodeBase64String(md.digest(dataBytes));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(encodeSHA1("abc"));
	}
}
