package com.monicseq.run.data.generator;

import java.util.Random;

/**
 * comment here
 *
 * @author Duyining
 * @date 2019/12/18
 */
public class StringGenerator {

    private static String ALLCHAR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    /**
     * 随机字符串，0-10位
     * @return 字符串
     */
    public static String getRandomString() {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < new Random().nextInt(10); i++) {
            int number = random.nextInt(62);
            sb.append(StringGenerator.ALLCHAR.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 生成min-max长度的随机字符串
     * @param min 最小长度
     * @param max 最大长度
     * @return 字符串
     */
    public static String getRandomString(int min,int max) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < min + new Random().nextInt(max); i++) {
            int number = random.nextInt(62);
            sb.append(StringGenerator.ALLCHAR.charAt(number));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getRandomString(5,13));
    }
}
