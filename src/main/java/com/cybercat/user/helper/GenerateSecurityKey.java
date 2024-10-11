package com.cybercat.user.helper;

import java.util.Random;

public class GenerateSecurityKey {
	private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private static final int RANDOM_LENGTH = 8;
	
	public static String main() {
		String result = generateRandomString();
//		System.out.println(result);
		return result;
	}
	private static String generateRandomString() {
		StringBuffer result = new StringBuffer();
		for(int i = 0; i < RANDOM_LENGTH; i++) {
			int number = getRandomNumber();
			char ch = CHAR_LIST.charAt(number);
			result.append(ch);
//			System.out.println(result);
		}
		return result.toString();
	}
	
	private static int getRandomNumber() {
		int randomNumber = 0;
		Random generateRandomNumber = new Random();
		randomNumber = generateRandomNumber.nextInt(CHAR_LIST.length());
		if(randomNumber -1 == -1) {
			System.out.println(randomNumber);
			return randomNumber;
		}
		return randomNumber - 1;
	}
}
