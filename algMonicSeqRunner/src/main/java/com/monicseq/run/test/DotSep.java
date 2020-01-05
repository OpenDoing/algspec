package com.monicseq.run.test;

/**
 * comment here
 *
 * @author Duyining
 * @date 2020/1/5
 */
public class DotSep {

    public static void main(String[] args) {
        String s = "ireq.id";
        System.out.println(s.substring(0,s.indexOf(".")));
        System.out.println(s.substring(s.indexOf(".")));
    }
}
