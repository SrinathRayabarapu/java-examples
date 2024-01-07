package com.core.hash;

import com.core.utils.HexUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class MessageDigesterHashingMain {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String myPassword = "my secret password";
        String[] algorithms = {"MD5", "SHA-1", "SHA-256"};
        byte[] salt = createSalt();

        byte[] hashBytes = generateHash(myPassword, algorithms[0], salt);
        System.out.println(algorithms[0] + " Hashed password in Hex : " + HexUtils.formatToHex(hashBytes));

        hashBytes = generateHash(myPassword, algorithms[1], salt);
        System.out.println(algorithms[1] + " Hashed password in Hex : " + HexUtils.formatToHex(hashBytes));

        hashBytes = generateHash(myPassword, algorithms[2], salt);
        System.out.println(algorithms[2] + " Hashed password in Hex : " + HexUtils.formatToHex(hashBytes));
    }

    private static byte[] createSalt() {
        var salt = new byte[20];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(salt);
        return salt;
    }

    private static byte[] generateHash(String password, String algorithm, byte[] salt) throws NoSuchAlgorithmException {
        var messageDigest = MessageDigest.getInstance(algorithm);
        messageDigest.reset();
        messageDigest.update(salt);
        return messageDigest.digest(password.getBytes());
    }

}
