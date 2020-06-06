package edu.njust.hjj.asts.bean;

import java.util.List;

public class Operation {
    private String name;        //操作名
    private List<String> argDT; //操作参数类型表(可为空(常操作 变量))
    private List<String> retDT; //操作返回类型列表
    private String optType;     //操作类型：常、变、属性、检索、转换
    private String optBelong;   //操作所属类子

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getArgDT() {
        return argDT;
    }

    public void setArgDT(List<String> argDT) {
        this.argDT = argDT;
    }

    public List<String> getRetDT() {
        return retDT;
    }

    public void setRetDT(List<String> retDT) {
        this.retDT = retDT;
    }

    public String getOptType() {
        return optType;
    }

    public void setOptType(String optType) {
        this.optType = optType;
    }

    public String getOptBelong() {
        return optBelong;
    }

    public void setOptBelong(String optBelong) {
        this.optBelong = optBelong;
    }

    public void testPrint(){
        System.out.println("name="+ name + " ,argDT=" + argDT + " ,retDT=" +
                retDT + " ,optType="+ optType + " ,optBelong=" + optBelong);

    }

    @Override
    public String toString() {
        return "name="+ name + " ,argDT=" + argDT + " ,retDT=" +
                retDT + " ,optType="+ optType + " ,optBelong=" + optBelong;
    }
}
