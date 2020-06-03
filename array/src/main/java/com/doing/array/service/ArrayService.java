package com.doing.array.service;

import java.util.List;

/**
 * 定义接口
 *
 * @author Duyining
 * @date 2019/12/5
 */
public interface ArrayService {

    /**
     * 返回数组的最小值
     * @param id 数组标识
     * @return 最小值
     */
    Integer getMin(Integer id);

    /**
     * 返回数组的最大值
     * @param id 数组标识
     * @return 最大值
     */
    Integer getMax(Integer id);

    /**
     * 某索引位置的元素
     * @param id 数组标识
     * @param index 索引值
     * @return 元素
     */
    Integer getElement(Integer id,Integer index);

    /**
     * 返回某元素的索引位置
     * @param id 数组标识
     * @param ele 元素
     * @return 索引
     */
    Integer getIndex(Integer id,Integer ele);

    /**
     * 数组求和
     * @param id 数组标识
     * @return 和
     */
    Integer sum(Integer id);

    /**
     * 在某位置加入某元素
     * @param id 数组标识
     * @param ele 元素
     * @param index 索引
     */
    void insert(Integer id,Integer ele,Integer index);

    /**
     * 清空数组
     * @param id 数组标识
     */
    void clear(Integer id);

    /**
     * 删除某索引位置的元素
     * @param id 数组标识
     */
    void del(Integer id,Integer index);

    /**
     * 递增排序数组
     * @param id 数组标识
     */
    void isort(Integer id);

    /**
     * 递减排序数组
     * @param id 数组标识
     */
    void dsort(Integer id);

    /**
     * 数组逆序
     * @param id 数组标识
     */
    void reverse(Integer id);

    /**
     * 返回数组的全部元素
     * @param id 数组标识
     * @return 数组
     */
    String getArray(Integer id);

    /**
     * 修改数组某位置的元素
     * @param id 数组标识
     * @param index 数组索引位置
     * @param ele 修改元素的目标值
     */
    void modifyEle(Integer id,Integer index,Integer ele);

    /**
     * 删除一个数组
     * @param id 数组标识
     */
    void deleArray(Integer id);
}
