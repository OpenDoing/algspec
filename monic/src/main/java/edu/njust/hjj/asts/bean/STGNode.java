package edu.njust.hjj.asts.bean;

import java.util.List;

public class STGNode {
    private String name; //结点名
    private String datatype; //结点的数据类型(操作结点的数据类型为"")，也可以标识结点类型（实体/操作）
    private List<STGNode> parents;  //父结点
    private List<STGNode> childs;   //子结点
}
