package com.meitu.search.util;

import java.util.Random;

/**
 * @ClassName StringUtil
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/2 8:07
 */
public class StringUtil {
    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 判断字符串是否为空
     *
     * @param str 待判断的字符串
     * @return
     */
    public static boolean isEmpty(final String str) {
        return str == null || str.length() == 0;
    }
}
