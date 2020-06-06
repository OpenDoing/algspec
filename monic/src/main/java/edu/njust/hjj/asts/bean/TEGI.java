package edu.njust.hjj.asts.bean;

import java.util.ArrayList;
import java.util.List;

public class TEGI {
    private List<Node> optSet; //带参操作节点集合
    private List<Node> entitySet; //实体节点集合
    private List<Edge> edgeSet;  //边节点集合
    private Node start = null;
    private Node end = null;
    private int equalType = 0; //TEGI类型 ，1等式TEGI，2条件TEGI，3完整TEGI
    private String spec; //所属类子

    public TEGI(){
        this.optSet = new ArrayList<Node>();
        this.entitySet = new ArrayList<Node>();
        this.edgeSet = new ArrayList<Edge>();
    }

    public List<Node> getOptSet() {
        return optSet;
    }

    public void setOptSet(List<Node> optSet) {
        this.optSet = optSet;
    }

    public List<Node> getEntitySet() {
        return entitySet;
    }

    public void setEntitySet(List<Node> entitySet) {
        this.entitySet = entitySet;
    }

    public List<Edge> getEdgeSet() {
        return edgeSet;
    }

    public void setEdgeSet(List<Edge> edgeSet) {
        this.edgeSet = edgeSet;
    }

    public Node getStart() {
        return start;
    }

    public void setStart(Node start) {
        this.start = start;
    }

    public Node getEnd() {
        return end;
    }

    public void setEnd(Node end) {
        this.end = end;
    }

    public int getEqualType() {
        return equalType;
    }

    public void setEqualType(int equalType) {
        this.equalType = equalType;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public void Print(){
        for (Node n: this.getEntitySet()) {
            System.out.println(n + " 父结点:" + n.getParents()+ " 子结点:"+ n.getChilds() );
        }
        System.out.println();
        for (Node n: this.getOptSet()) {
            System.out.println(n + " 父结点:" + n.getParents()+ " 子结点:"+ n.getChilds() );
        }
        for (Edge e: this.getEdgeSet()) {
            System.out.println(e.getHead() + "->" + e.getTail());
        }
    }


}
