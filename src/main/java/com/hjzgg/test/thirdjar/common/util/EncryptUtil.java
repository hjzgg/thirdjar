package com.hjzgg.test.thirdjar.common.util;


public class EncryptUtil {

    public static String encryptPassed(String passwd) {
        String salt = "HelloWorld";
        return MD5Util.MD5Encode(passwd + salt, null);
    }
}
