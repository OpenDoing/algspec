package com.monicseq.run.data.generator;

import com.monicseq.run.data.TestData;

import java.util.Random;

/**
 * 小数随机
 *
 * @author Duyining
 * @date 2019/12/18
 */
public class DoubleGenerator implements TestData {

    /**
     * 随机小数
     * @return 小数
     */
    @Override
    public Object getRandom() {
        return new Random().nextDouble();
    }

    @Override
    public Object getRandom(Object o1, Object o2) {
        return null;
    }
}
