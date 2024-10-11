package com.cybercat.user.helper;

import java.security.Key;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class AESEncryption {
	private static final String ALGORITHM = "AES";
	private static final String KEY = "235ertr432wer432";
	private static final String salt = "235ertr@#*wer432";
	
	public static Key generateKey() throws Exception {
		
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		KeySpec spec = new PBEKeySpec(KEY.toCharArray(), salt.getBytes(), 4096*16, 256); 
		SecretKey tmp = factory.generateSecret(spec);
		Key key = new SecretKeySpec(tmp.getEncoded(), AESEncryption.ALGORITHM);
		return key;
	}
	
	public static String encrypt(String value) throws Exception {
		Key key = generateKey();
		byte[] iv = { 8, 5, 8, 4, 0, 5, 8, 0, 3, 1, 2, 8, 6, 0, 8, 3 };
		IvParameterSpec ivspec = new IvParameterSpec(iv);
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key,ivspec);
		
		byte[] encryptedByteValue = cipher.doFinal(value.getBytes("UTF-8"));
		String encryptedBase64 = Base64.getEncoder().encodeToString(encryptedByteValue);
		//System.out.println(encryptedBase64);
		String convertToHex = stringtohex(encryptedBase64);
		String convertToDecimal = hextodecimal(convertToHex);
		String convertToLongHex = convertToLongHex(convertToDecimal);
		return convertToLongHex;
	}
	
	private static String convertToLongHex(String convertToDecimal) {
		String[] decstrspl = convertToDecimal.split(",");
		int g[] = new int[decstrspl.length];
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i<decstrspl.length;i++) {
			g[i] = Integer.parseInt(decstrspl[i]);
		}
		for(int i=0; i<g.length;i++) {
			sb.append(Integer.toHexString(g[i]));
		}
		return sb.toString();
	}
	
	public static String decrypt(String value) throws Exception {
		String compressLongHex = hextodecimal1(value);
		String longhexCompressed = longHexCompressed(compressLongHex);
		String convertToEncrytpion = hextostring(longhexCompressed);
		Key key = generateKey();
		byte[] iv = { 8, 5, 8, 4, 0, 5, 8, 0, 3, 1, 2, 8, 6, 0, 8, 3 };
		IvParameterSpec ivspec = new IvParameterSpec(iv);
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(cipher.DECRYPT_MODE, key,ivspec);
		byte[] decryptedValue64 = Base64.getDecoder().decode(convertToEncrytpion);
		byte[] decryptedByteValue = cipher.doFinal(decryptedValue64);
		String decryptedValue = new String(decryptedByteValue,"UTF-8");
		return decryptedValue;
	}
	private static String longHexCompressed(String compressLongHex) {
		String[] resverspl = compressLongHex.split(",");
		StringBuffer sb1 = new StringBuffer();
		int r[] = new int[resverspl.length];
		for(int i = 0; i<resverspl.length;i++) {
			r[i] = Integer.parseInt(resverspl[i]);
		}
		for(int i=0; i<r.length;i++) {
			sb1.append(Integer.toHexString(r[i]));
		}
		return sb1.toString();
	}
	private static String hextodecimal(String value) {
		String digits = "0123456789ABCDEF";
		value = value.toUpperCase();
		StringBuffer num = new StringBuffer();
		int val = 0;
		for(int i=0;i<value.length()-1;) {
			val=0;
			for(int j=i; j<=i+1;j++) {
			char c = value.charAt(j);
			int d = digits.indexOf(c);
			val = 16*val + d;
			}
			i+=2;

			num.append(val*8+",");
		}
		return num.deleteCharAt(num.toString().lastIndexOf(",")).toString();
	}
	
	private static String hextodecimal1(String value) {
		String digits = "0123456789ABCDEF";
		value = value.toUpperCase();
		StringBuffer num = new StringBuffer();
		int val = 0;
		for(int i=0;i<value.length()-2;) {
			val=0;
			for(int j=i; j<=i+2;j++) {
			char c = value.charAt(j);
			int d = digits.indexOf(c);
			val = 16*val + d;
			}
			i+=3;
			num.append(val/8+",");
		}
		return num.deleteCharAt(num.toString().lastIndexOf(",")).toString();
	}
	
	private static String stringtohex(String value) {
		StringBuffer val = new StringBuffer();
		char[] arr = value.toCharArray();
		for(int i=0; i<arr.length;i++) {
			val.append(Integer.toHexString(arr[i]));
		}
		return val.toString();
	}
	
	private static String hextostring(String value) {
		StringBuffer result = new StringBuffer();
		char[] arr = value.toCharArray();
		for(int i=0; i<arr.length;i+=2) {
			String str = ""+arr[i]+""+arr[i+1];
			char ch = (char) Integer.parseInt(str,16);
			result.append(ch);
		}
		return result.toString();
	}

}
