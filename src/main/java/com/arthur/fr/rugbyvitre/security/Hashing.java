package com.arthur.fr.rugbyvitre.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class Hashing {

    private static Map<String, String> securePassword(String password, String salt) {

        Map<String, String> dictionary = new HashMap<String, String>();
        String passwordHash = hashPassword(password, salt);
        dictionary.put("password", passwordHash);
        dictionary.put("key", salt);

        return dictionary;
    }

    private static String getSalt() throws NoSuchAlgorithmException {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[20];
        random.nextBytes(bytes);
        Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();
        return encoder.encodeToString(bytes);
    }


    public static Map<String, String> passwordHash(String password) throws NoSuchAlgorithmException {
        String salt = getSalt();
        return securePassword(password, salt);
    }

    public static boolean checkPassword(String password, String key, String passwordAccount){
        String generatedPassword = hashPassword(password, key);
        System.out.println(generatedPassword);
        System.out.println(generatedPassword.equals(passwordAccount));
        return generatedPassword.equals(passwordAccount);
    }

    private static String hashPassword(String password, String key) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(key.getBytes());
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
}
