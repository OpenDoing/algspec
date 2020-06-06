package edu.njust.hjj.asts.bean;

public class OperationBean {
    private String name;        //操作名
    private String argDT; //操作参数类型
    private String retDT; //操作返回类型
    private String optType;     //操作类型：常、变、属性、检索、转换
    private String optBelong;   //操作所属类子

    public String getName() {
        return name;
    }

    public String getArgDT() {
        return argDT;
    }

    public String getRetDT() {
        return retDT;
    }

    public String getOptType() {
        return optType;
    }

    public String getOptBelong() {
        return optBelong;
    }

    @Override
    public String toString() {
        return "name="+ name + " ,argDT=" + argDT + " ,retDT=" +
                retDT + " ,optType="+ optType + " ,optBelong=" + optBelong;
    }
}
