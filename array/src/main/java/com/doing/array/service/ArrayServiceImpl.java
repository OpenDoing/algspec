package com.doing.array.service;

import com.doing.array.dao.ArrayRepo;
import com.doing.array.entity.Array;
import com.doing.array.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * comment here
 *
 * @author Duyining
 * @date 2019/12/5
 */
@Service
public class ArrayServiceImpl implements ArrayService {
    @Autowired
    private ArrayRepo arrayRepo;

    @Override
    public Integer getMin(Integer id) {
        Array array = arrayRepo.findArrayById(id);
        List<Integer> list = ListUtil.s2l(array.getEle());
        return Collections.min(list);
    }

    @Override
    public Integer getMax(Integer id) {
        Array array = arrayRepo.findArrayById(id);
        List<Integer> list = ListUtil.s2l(array.getEle());
        return Collections.max(list);
    }

    @Override
    public Integer getElement(Integer id, Integer index) {
        Array array = arrayRepo.findArrayById(id);
        List<Integer> list = ListUtil.s2l(array.getEle());
        if (index < list.size()) {
            return list.get(index);
        }
        return null;
    }

    @Override
    public Integer getIndex(Integer id, Integer ele) {
        Array array = arrayRepo.findArrayById(id);
        List<Integer> list = ListUtil.s2l(array.getEle());
        if (list.contains(ele)) {
            return list.indexOf(ele);
        }
        return -1;
    }

    @Override
    public Integer sum(Integer id) {
        Array array = arrayRepo.findArrayById(id);
        List<Integer> list = ListUtil.s2l(array.getEle());
        int sum = 0;
        for (Integer i:list){
            sum = sum + i;
        }
        return sum;
    }

    @Override
    public void insert(Integer id, Integer ele, Integer index) {
        Array array = arrayRepo.findArrayById(id);
        if (array == null) {
            Array array1 = new Array();
            List<Integer> list = new ArrayList();
            list.add(index,ele);
            array1.setEle(list.toString());
            arrayRepo.save(array1);
        } else {
            List<Integer> list = ListUtil.s2l(array.getEle());
            list.add(index,ele);
            array.setEle(list.toString());
            arrayRepo.save(array);
        }
    }

    @Override
    public void deleArray(Integer id) {
        arrayRepo.deleteById(id);
    }

    @Override
    public void clear(Integer id) {
        Array array = arrayRepo.findArrayById(id);
        array.setEle("");
        arrayRepo.save(array);

    }

    @Override
    public void del(Integer id, Integer index) {
        Array array = arrayRepo.findArrayById(id);
        List<Integer> list = ListUtil.s2l(array.getEle());
        list.remove((int)index);
        array.setEle(list.toString());
        arrayRepo.save(array);
    }

    @Override
    public void isort(Integer id) {
        Array array = arrayRepo.findArrayById(id);
        List<Integer> list = ListUtil.s2l(array.getEle());
        Collections.sort(list);
        array.setEle(list.toString());
        arrayRepo.save(array);
    }

    @Override
    public void dsort(Integer id) {
        Array array = arrayRepo.findArrayById(id);
        List<Integer> list = ListUtil.s2l(array.getEle());
        Collections.sort(list);
        Collections.reverse(list);
        array.setEle(list.toString());
        arrayRepo.save(array);
    }

    @Override
    public void reverse(Integer id) {
        Array array = arrayRepo.findArrayById(id);
        List<Integer> list = ListUtil.s2l(array.getEle());
        Collections.reverse(list);
        array.setEle(list.toString());
        arrayRepo.save(array);
    }

    @Override
    public String getArray(Integer id) {
        Array array = arrayRepo.findArrayById(id);
        if (array==null){
            return "null";
        }
        return array.getEle();
    }

    @Override
    public void modifyEle(Integer id, Integer index,Integer ele) {
        Array array = arrayRepo.findArrayById(id);
        List<Integer> list = ListUtil.s2l(array.getEle());
        list.set(index,ele);
        array.setEle(list.toString());
        arrayRepo.save(array);
    }
}
