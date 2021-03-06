package com.monicseq.run.data.generator;

import com.monicseq.run.data.TestData;

import java.util.Random;

/**
 * Integer数据生成器
 *
 * @author Duyining
 * @date 2019/12/18
 */
public class IntegerGenerator implements TestData{

    /**
     * 随机生成int值
     *
     * @return 随机int值
     */
    public static int getRandomInt() {
        int min = 1;
        int max = 100;
        int intrandom = min + ((int) (new Random().nextFloat() * (max - min)));
        return new Random().nextInt();
    }

    /**
     * 随机生成 min - max的整型数据
     * @param min 最小值
     * @param max 最大值
     * @return 区间随机值
     */
    public static int getRandomInt(int min,int max) {
        return min + ((int) (new Random().nextFloat() * (max - min)));
    }

    /**
     * 生成比min大的数值
     * @param min 最小值
     * @return 比min大的数值
     */
    public static int getGreaterInt(int min) {
        return min + new Random().nextInt();
    }

    /**
     * 上界为max的正数值不包含max
     * @param max 最大值
     * @return 比min大的数值
     */
    public static int getLessInt(int max) {
        return new Random().nextInt(max);
    }

    public static void main(String[] args) {
        IntegerGenerator integerGenerator = new IntegerGenerator();

        System.out.println(integerGenerator.getRandom(9, 5));
    }

    @Override
    public Object getRandom() {
        return new Random().nextInt();
    }

    @Override
    public Object getRandom(Object o1, Object o2) {
        return Integer.parseInt(o1.toString()) + ((int) (new Random().nextFloat() * (Integer.parseInt(o2.toString())-Integer.parseInt(o1.toString()))));
    }
}
