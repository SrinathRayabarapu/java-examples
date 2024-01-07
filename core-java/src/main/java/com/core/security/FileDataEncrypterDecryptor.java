package com.core.security;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;

public class FileDataEncrypterDecryptor {
	public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
	public static final String DES_ENCRYPTION_SCHEME = "DES";
	// public static final String DEFAULT_ENCRYPTION_KEY =
	// "This is a fairly long phrase used to encrypt";
	public static final String DEFAULT_ENCRYPTION_KEY = "123456789012345678901234567890";

	private KeySpec keySpec;
	private SecretKeyFactory keyFactory;
	private Cipher cipher;

	private static final String UNICODE_FORMAT = "UTF8";

	public FileDataEncrypterDecryptor(String encryptionScheme)
			throws EncryptionException {
		this(encryptionScheme, DEFAULT_ENCRYPTION_KEY);
	}

	public FileDataEncrypterDecryptor(String encryptionScheme,
			String encryptionKey) throws EncryptionException {

		if (encryptionKey == null)
			throw new IllegalArgumentException("encryption key was null");

		if (encryptionKey.trim().length() < 24)
			throw new IllegalArgumentException(
					"encryption key was less than 24 characters");

		try {
			byte[] keyAsBytes = encryptionKey.getBytes(UNICODE_FORMAT);

			System.out.println("Encryption key length : " + keyAsBytes.length);

			if (encryptionScheme.equals(DESEDE_ENCRYPTION_SCHEME)) {
				keySpec = new DESedeKeySpec(keyAsBytes);
			} else if (encryptionScheme.equals(DES_ENCRYPTION_SCHEME)) {
				keySpec = new DESKeySpec(keyAsBytes);
			} else {
				throw new IllegalArgumentException(
						"Encryption scheme not supported: " + encryptionScheme);
			}

			keyFactory = SecretKeyFactory.getInstance(encryptionScheme);
			cipher = Cipher.getInstance(encryptionScheme);

		} catch (InvalidKeyException e) {
			throw new EncryptionException(e);
		} catch (UnsupportedEncodingException e) {
			throw new EncryptionException(e);
		} catch (NoSuchAlgorithmException e) {
			throw new EncryptionException(e);
		} catch (NoSuchPaddingException e) {
			throw new EncryptionException(e);
		}
	}

	public void encrypt(String encrFilePath, String decrFilePath)
			throws EncryptionException {

		String encryptedStringToken = null;
		BufferedReader reader = null;
		BufferedWriter out = null;
		StringBuffer stringBuffer = new StringBuffer();
		int i = 1;

		if (encrFilePath == null || encrFilePath.trim().length() == 0
				|| decrFilePath == null || decrFilePath.trim().length() == 0)
			throw new IllegalArgumentException(
					"unencrypted file path was null or empty");

		try {
			reader = new BufferedReader(new FileReader(encrFilePath));

			while ((encryptedStringToken = reader.readLine()) != null) {

				String[] enc_Token = encryptedStringToken.split("=");

				// StringTokenizer tokenizer = new
				// StringTokenizer(encryptedStringToken,"=");

				System.out.println(enc_Token[1]);

				SecretKey key = keyFactory.generateSecret(keySpec);
				System.out.println("In Encryption " + key);
				cipher.init(Cipher.ENCRYPT_MODE, key);

				byte[] cleartext = enc_Token[1].getBytes(UNICODE_FORMAT);

				byte[] ciphertext = cipher.doFinal(cleartext);

				// BASE64Encoder base64encoder = new BASE64Encoder();
				// return new String(Base64.encodeBase64( ciphertext ));

				String tempString = "Key" + i + "="
						+ new String(Base64.encodeBase64(ciphertext)) + "\n";

				stringBuffer.append(tempString);

				i++;
			}

			out = new BufferedWriter(new FileWriter(decrFilePath));
			out.write(stringBuffer.toString());

		} catch (Exception e) {
			throw new EncryptionException(e);
		} finally {
			try {
				reader.close();
				out.close();
			} catch (IOException e) {
			}
		}
	}

	public void decrypt(String decrFilePath) throws EncryptionException {
		BufferedReader reader = null;
		String encryptedStringToken = null;

		if (decrFilePath == null || decrFilePath.trim().length() <= 0)
			throw new IllegalArgumentException(
					"encrypted string was null or empty");

		try {
			reader = new BufferedReader(new FileReader(decrFilePath));

			while ((encryptedStringToken = reader.readLine()) != null) {

				String[] enc_Token = encryptedStringToken.split("=");

				System.out.println(enc_Token);
				System.out.println(enc_Token[1]);

				// String temp = enc_Token[1]+enc_Token[2];

				SecretKey key = keyFactory.generateSecret(keySpec);
				System.out.println("In Decryption " + key);
				cipher.init(Cipher.DECRYPT_MODE, key);

				// BASE64Decoder base64decoder = new BASE64Decoder();

				byte[] cleartext = enc_Token[1].getBytes(UNICODE_FORMAT);

				// byte[] cleartext = Base64.decodeBase64( enctext );
				byte[] ciphertext = cipher.doFinal(cleartext);

				System.out.println(bytes2String(ciphertext));
			}
		} catch (Exception e) {
			throw new EncryptionException(e);
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
			}
		}
	}

	private static String bytes2String(byte[] bytes) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			stringBuffer.append((char) bytes[i]);
		}
		return stringBuffer.toString();
	}

	public static void main(String[] args) {
		try {
			FileDataEncrypterDecryptor fileEncrypterDectyptor = new FileDataEncrypterDecryptor(
					"DES");
			// String inputString = "valtech";

			String encrFilePath = "D:/WorkSpace/JavaPractice/src/com/core/security/secrete.properties";
			String decrFilePath = "D:/WorkSpace/JavaPractice/src/com/core/security/secrete1.properties";

			fileEncrypterDectyptor.encrypt(encrFilePath, decrFilePath);

			fileEncrypterDectyptor.decrypt(decrFilePath);

		} catch (EncryptionException e) {
			e.printStackTrace();
		}
	}
}

class EncryptionException extends Exception {

	private static final long serialVersionUID = 1L;

	public EncryptionException(Throwable t) {
		super(t);
	}
}
