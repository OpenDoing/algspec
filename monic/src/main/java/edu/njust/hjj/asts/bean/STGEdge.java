package edu.njust.hjj.asts.bean;

public class STGEdge {
    private STGNode head;
    private STGNode tail;
    private Integer order;  //边的顺序，0开始，表示输入输出参数顺序输入输出参数顺序
    private boolean type; //边类型（true实线，false虚线）
}
