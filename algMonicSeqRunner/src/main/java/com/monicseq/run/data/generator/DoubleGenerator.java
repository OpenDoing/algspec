package com.monicseq.run.data.generator;

import java.util.Random;

/**
 * 小数随机
 *
 * @author Duyining
 * @date 2019/12/18
 */
public class DoubleGenerator {

    /**
     * 随机小数
     * @return 小数
     */
    public static Double getRandomDouble(){
        return new Random().nextDouble();
    }


}
