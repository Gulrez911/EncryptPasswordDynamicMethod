package com.gul.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SHA_Example {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		String passwordToHash = "password";
		byte[] salt = getSalt();
		System.out.println("Main Salt: "+salt);
		String securePassword; 
		securePassword	= get_SHA_1_SecurePassword(passwordToHash, salt);
		System.out.println(securePassword);

		securePassword = get_SHA_256_SecurePassword(passwordToHash, salt);
		System.out.println(securePassword);

		securePassword = get_SHA_384_SecurePassword(passwordToHash, salt);
		System.out.println(securePassword);

		securePassword = get_SHA_512_SecurePassword(passwordToHash, salt);
		System.out.println(securePassword);
	}

	private static String get_SHA_1_SecurePassword(String passwordToHash, byte[] salt) {
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(salt);
			byte[] bytes = md.digest(passwordToHash.getBytes());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}

	private static String get_SHA_256_SecurePassword(String passwordToHash, byte[] salt) {
//		 Use	 MessageDigest md = MessageDigest.getInstance("SHA-256");
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(salt);
			byte[] bytes = md.digest(passwordToHash.getBytes());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}

	private static String get_SHA_384_SecurePassword(String passwordToHash, byte[] salt) {
		// Use MessageDigest md = MessageDigest.getInstance("SHA-384");
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-384");
			md.update(salt);
			byte[] bytes = md.digest(passwordToHash.getBytes());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}

	private static String get_SHA_512_SecurePassword(String passwordToHash, byte[] salt) {
		// Use MessageDigest md = MessageDigest.getInstance("SHA-512");
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(salt);
			byte[] bytes = md.digest(passwordToHash.getBytes());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}

	// Add salt
	private static byte[] getSalt() throws NoSuchAlgorithmException {
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt = new byte[16];
		sr.nextBytes(salt);
		System.out.println("Salt: "+salt);
		return salt;
	}
}
