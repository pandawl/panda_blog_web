package com.panda.common.util;

import org.apache.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

public class DESUtil {

    private static Logger logger = Logger.getLogger(DESUtil.class);

    private static final String PASSWORD_CRYPT_KEY = "xwfospngikr@dg";
    private final static String DES = "DES";

    /**
     * @param src
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] src, byte[] key) throws Exception {
        SecureRandom sr = new SecureRandom();
        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance(DES);
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
        return cipher.doFinal(src);
    }

    /**
     * @param src
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] src, byte[] key) throws Exception {
        SecureRandom sr = new SecureRandom();
        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance(DES);
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
        return cipher.doFinal(src);
    }

    /**
     * decrypt with salt
     *
     * @param data
     * @return
     */
    public final static String decrypt(String data, String salt) {
        try {
            String key = PASSWORD_CRYPT_KEY.concat(salt);
            return new String(
                    decrypt(HexUtil.toByteArray(data), key.getBytes()));
        } catch (Exception e) {
            logger.error(e, e);
            return null;
        }
    }

    /**
     * encrypt with salt
     *
     * @param data
     * @return
     */
    public final static String encrypt(String data, String salt) {
        try {
            String key = PASSWORD_CRYPT_KEY.concat(salt);
            return HexUtil
                    .toHexString(encrypt(data.getBytes(), key.getBytes()));
        } catch (Exception e) {
            logger.error(e, e);
            return null;
        }
    }

    public static void main(String[] args) {
        String salt = "nim*Password%salt";
        String str = DESUtil.encrypt("1234", salt);
        System.out.println(str);
        System.out.println(DESUtil.decrypt(str, salt));
    }
}
