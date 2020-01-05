package com.monicseq.run.data;

/**
 * 测试数据接口
 *
 * @author Duyining
 * @date 2019/12/26
 */
public interface TestData {
    /**
     * 没有限制的随机生成
     * @return 随机数据
     */
    Object getRandom();

    /**
     * 在上限和下限区间内 生成数据
     * @param o1 下限
     * @param o2 上限
     * @return 区间内数据
     */
    Object getRandom(Object o1, Object o2);

}
