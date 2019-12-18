package com.monicseq.run.data;

import java.util.Random;

/**
 * 随机策略生成数据
 *
 * @author Duyining
 * @date 2019/12/9
 */
public class TestDataGenerator {

    /**
     * 随机生成0到100的随机int值
     *
     * @return 随机int值
     */
    public static int getRandomInt() {
        int min = 1;
        int max = 100;
        int intrandom = min + ((int) (new Random().nextFloat() * (max - min)));
        return intrandom;
    }

    /**
     * 随机生成min - max的整型数据
     * @param min 最小值
     * @param max 最大值
     * @return 区间随机值
     */
    public static int getRandomInt(int min,int max) {
        return min + ((int) (new Random().nextFloat() * (max - min)));
    }


    public static void main(String[] args) {
        getRandomInt();
    }



}
