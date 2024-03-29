package com.anzh.utils;

import java.security.MessageDigest;

public class MD5Util {
    private static final String MD5_ALGORITHM = "MD5";

    public MD5Util() {
    }

    public static final String MD5(String s) throws Exception {
        char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        byte[] btInput = s.getBytes();
        MessageDigest mdInst = MessageDigest.getInstance(MD5_ALGORITHM);
        mdInst.update(btInput);
        byte[] md = mdInst.digest();
        int j = md.length;
        char[] str = new char[j * 2];
        int k = 0;

        for(int i = 0; i < j; ++i) {
            byte byte0 = md[i];
            str[k++] = hexDigits[byte0 >>> 4 & 15];
            str[k++] = hexDigits[byte0 & 15];
        }

        return new String(str);
    }
}
