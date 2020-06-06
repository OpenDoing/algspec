package edu.njust.hjj.asts.bean;

public class Edge {
    private Node head;
    private Node tail;
    private Integer order;  //边的顺序，0开始，表示输入输出参数顺序输入输出参数顺序
    private boolean type; //边类型（true实线，false虚线）

    public Edge(Node head, Node tail, Integer order, boolean type) {
        this.head = head;
        this.tail = tail;
        this.order = order;
        this.type = type;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    @Override
    public String toString() {
        if(type){
            return head.hashCode()+"->"+tail.hashCode()+";";
        }else {
            return head.hashCode() + "->" + tail.hashCode() + "[style=dotted];";
        }
    }
}
