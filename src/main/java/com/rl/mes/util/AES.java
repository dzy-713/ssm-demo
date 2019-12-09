package com.rl.mes.util;


import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author douzy
 * @date 2019-07-18.
 */
public final class AES {
    private static final String sKey = "abcdef0123456789";
    private static final String ivParameter = "0102030405060708";
    private static final String CipherInstance = "AES/CBC/PKCS5Padding";

    public AES() {
    }

    public static String encrypt2(String content, String key) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(key.getBytes());
        kgen.init(128, random);
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec keySpec = new SecretKeySpec(enCodeFormat, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        byte[] byteContent = content.getBytes("utf-8");
        cipher.init(1, keySpec);
        byte[] result = cipher.doFinal(byteContent);
        return Base64.getEncoder().encodeToString(result);
    }

    public static String encrypt2(String content) {
        try {
            return encrypt2(content, "abcdef0123456789");
        } catch (Exception var2) {
            throw new RuntimeException(var2);
        }
    }

    public static String decrypt2(String content, String key) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(key.getBytes());
        kgen.init(128, random);
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec keySpec = new SecretKeySpec(enCodeFormat, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(2, keySpec);
        byte[] result = cipher.doFinal(Base64.getDecoder().decode(content));
        return new String(result);
    }

    public static String decrypt2(String content) {
        try {
            return decrypt2(content, "abcdef0123456789");
        } catch (Exception var2) {
            throw new RuntimeException(var2);
        }
    }


    public static void main(String[] args) {
        String s = AES.encrypt2("{\"licenseDate\":\"2019-8-11\"}");
        System.out.println(s);
        String s2 = AES.encrypt2("{\"licenseDate\":\"max\"}");
        System.out.println(s2);
    }


}
