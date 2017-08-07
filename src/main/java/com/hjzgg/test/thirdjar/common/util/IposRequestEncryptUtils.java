package com.hjzgg.test.thirdjar.common.util;

import java.util.Map;
import java.util.TreeMap;


public class IposRequestEncryptUtils {

    public static String getSalt(Map<String, Object> params) {
        TreeMap<String, Object> afterSort = new TreeMap<>(params);
        StringBuffer buffer = new StringBuffer();
        for (Map.Entry<String, Object> entry : afterSort.entrySet()) {
            buffer.append(entry.getKey()).append("=").append(entry.getValue());
            buffer.append("&");
        }
        buffer.append("fpowkennfi");
        String salt = MD5Util.MD5Encode(buffer.toString(), "UTF-8");
        return salt.toUpperCase();
    }

}
