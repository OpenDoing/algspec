package edu.njust.hjj.asts.bean;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String name; //结点名
    private String datatype; //结点的数据类型(操作结点的数据类型为"")，也可以标识结点类型（实体/操作）
    private List<Node> parents;  //父结点
    private List<Node> childs;   //子结点
    private boolean visited = false;   //true已经访问，false未访问
    private int priority = 0;     //优先级，转换操作为3，检索操作为2，其它为1

    public Node(String name, String datatype, List<Node> parents, List<Node> childs) {
        this.name = name;
        this.datatype = datatype;
        this.parents = new ArrayList<Node>();
        if(parents != null){
            for (Node parent:parents) {
                this.parents.add(parent);
            }
        }

        this.childs = new ArrayList<Node>();
        if(childs != null){
            for (Node child:childs) {
                this.childs.add(child);
            }
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public List<Node> getParents() {
        return parents;
    }

    public void setParents(List<Node> parents) {
        this.parents = parents;
    }

    public List<Node> getChilds() {
        return childs;
    }

    public void setChilds(List<Node> childs) {
        this.childs = childs;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        if(this.datatype.length() == 0)
            //return label + ":" + name ;
            return this.hashCode() + "[label="+"\""+name+"\""+"];";
        else {
            //return lable +":"+ name + ":" + datatype;
            return this.hashCode() +"[label=" +"\""+ name + ":" +datatype+"\""+",shape=record];";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(this.name.equals(((Node)obj).getName()) && this.datatype.equals(((Node)obj).getDatatype())){
            if(this.parents.size() == 0 && ((Node)obj).parents.size() == 0)
                return true;
            else if(this.parents.size() != ((Node)obj).parents.size())
                return false;
            else {
                List<Node> oneList = new ArrayList<Node>();
                List<Node> twoList = new ArrayList<Node>();
                for(int i = 0; i < this.parents.size(); i++){
                    oneList.add(this.parents.get(i));
                    twoList.add(((Node)obj).parents.get(i));
                }
                int nCount = 0;
                for(int i = 0; i < this.parents.size(); i++){
                    for(int j = 0; j < ((Node)obj).parents.size(); j++){
                        if(oneList.get(i) == twoList.get(j)){
                            nCount++;
                            break;
                        }
                    }
                }
                if (nCount == this.parents.size()) {
                    return true;
                }else {
                    return false;
                }
            }
        }
        return false;
    }

}
