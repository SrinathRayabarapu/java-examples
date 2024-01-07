package com.core.security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Scanner;

/**
 * This program generates a AES key, retrieves its raw bytes, and then
 * reinstantiates a AES key from the key bytes. The reinstantiated key is used
 * to initialize a AES cipher for encryption and decryption.
 */
public class AESTest {

	/**
	 * Turns array of bytes into string
	 * 
	 * @param buf
	 *            Array of bytes to convert to hex string
	 * @return Generated hex string
	 */
	public static String byteToHex(byte buf[]) {
		StringBuffer strbuf = new StringBuffer(buf.length * 2);
		int i;
		for (i = 0; i < buf.length; i++) {
			if (((int) buf[i] & 0xff) < 0x10)
				strbuf.append("0");

			strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
		}
		return strbuf.toString();
	}

	public static void main(String[] args) throws Exception {

		// Get the KeyGenerator
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(128); // 192 and 256 bits may not be available

		// Generate the secret key specs.
		SecretKey skey = kgen.generateKey();

		System.out.println("Generated skey " + skey);

		skey.getEncoded();

		// Instantiate the cipher with Algorithm and operation mode
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, skey);

		System.out.println("Please enter a clearText");
		Scanner scanner = new Scanner(System.in);
		String clearText = scanner.nextLine();

		System.out.println("Before Encryption " + clearText);
		byte[] encrypted = cipher.doFinal(clearText.getBytes());

		System.out.println("Encrypted string: " + byteToHex(encrypted));

		// Instantiate the cipher with keySpec and operation mode
		cipher.init(Cipher.DECRYPT_MODE, skey);

		byte[] original = cipher.doFinal(encrypted);

		String originalString = new String(original);

		System.out.println("After decryption string: " + originalString);
	}
}
