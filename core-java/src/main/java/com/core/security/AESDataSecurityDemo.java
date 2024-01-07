package com.core.security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;

public class AESDataSecurityDemo {
	public static void main(String[] args) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128); // 192 and 256 bits may not be available
			SecretKey skey = kgen.generateKey();

			encrypt(skey);
			decrypt(skey);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void encrypt(SecretKey skey) {
		InputStream in = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, skey);

			in = new BufferedInputStream(new FileInputStream(new File(
					"d:/plain.txt")));

			int theByte = 0;
			while ((theByte = in.read()) != -1) {
				baos.write(theByte);
			}

			byte[] encrypted = cipher.doFinal(baos.toByteArray());
			baos.close();
			in.close();

			ByteArrayOutputStream out1 = new ByteArrayOutputStream();
			out1.write(encrypted);
			out1.flush();

			// out.write(encrypted);
			// decrypt(encrypted,skey);
			OutputStream fout = new FileOutputStream(new File("d:/enc.txt"));
			out1.writeTo(fout);

			out1.reset();
			out1.close();
			fout.flush();
			fout.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
				if (baos != null)
					baos.close();
			} catch (IOException e) {
			}
		}
	}

	public static void decrypt(SecretKey skey) {
		InputStream in = null;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		try {
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, skey);
			in = new BufferedInputStream(new FileInputStream(new File(
					"d:/enc.txt")));

			int theByte = 0;
			while ((theByte = in.read()) != -1) {
				bout.write(theByte);
			}

			byte[] decrypted = cipher.doFinal(bout.toByteArray());
			FileOutputStream out = new FileOutputStream(new File("D:/dec.txt"));
			out.write(decrypted);

			in.close();
			bout.close();
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
				if (bout != null)
					bout.close();
			} catch (IOException e) {
			}
		}
	}
}
