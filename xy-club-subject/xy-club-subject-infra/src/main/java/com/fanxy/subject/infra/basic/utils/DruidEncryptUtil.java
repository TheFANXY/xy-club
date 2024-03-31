package com.fanxy.subject.infra.basic.utils;

import com.alibaba.druid.filter.config.ConfigTools;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * ClassName: DruidEncryptUtil
 * Package: com.fanxy.subject.infra.basic.utils
 * Description:
 *
 * @Author FanXY
 * @Create 2024/3/23 15:05
 * @Version 1.0
 */
public class DruidEncryptUtil {

    private static String privateKey;

    private static String publicKey;

    static {
        try {
            String [] keyPair = ConfigTools.genKeyPair(512);
            privateKey = keyPair[0];
            System.out.println("privateKey : " + privateKey);
            publicKey = keyPair[1];
            System.out.println("publicKey : " + publicKey);
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            throw new RuntimeException(e);
        }
    }

    public static String encrypt(String plainText) throws Exception {
        String encryptedText = ConfigTools.encrypt(privateKey, plainText);
        System.out.println("encryptedText : " + encryptedText);
        return encryptedText;
    }

    public static String decrypt(String encryptedText) throws Exception {
        String decryptedText = ConfigTools.decrypt(publicKey, encryptedText);
        System.out.println("decryptedText : " + decryptedText);
        return decryptedText;
    }
    public static void main(String[] args) throws Exception {
        String encrypt = encrypt("3663573wxf@");
        String decrypt = ConfigTools.decrypt("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAINecJVPPQKc9BEm0YBsitT6aoB9OUQhzvtm6NFOEBvsoUHe4j2k2tdkXPUXmzhHQb0LSSUIUPj9J34p66gKGgMCAwEAAQ==",
                "MtLZQT5a7lM6YtWnBJ87FfYEg++WA9/NUAXR0/vCP1f/4UmJJsdsO4m+a2Qy41dszDeShdQcHARMdBxNiQ4cwA==");
        System.out.println(decrypt);
    }
}
