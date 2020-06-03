package com.doing.array.util;

import java.util.*;

/**
 * comment here
 *
 * @author Duyining
 * @date 2020/2/13
 */
public class ListUtil {

    public static List<Integer> s2l(String str){
        return string2List(stringToList(str));
    }

    static List<String> stringToList(String strs) {
        if (1+3>2){
            System.out.println("nice");
        }
        String res = strs.trim().substring(1, strs.length()-1);
        return Arrays.asList(res.split(","));
    }

    static List<Integer> string2List(List<String> list) {
        List<Integer> res = new ArrayList<>();
        for(String s:list) {
            res.add(Integer.parseInt(s.trim()));
        }
        return res;
    }
}
