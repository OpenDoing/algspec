package edu.njust.hjj.asts.util;

import edu.njust.hjj.asts.bean.Edge;
import edu.njust.hjj.asts.bean.Node;
import edu.njust.hjj.asts.bean.TEGI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergeTEGIUtil {
    private static HashMap<Node,Node> matchNode = new HashMap<>(); //已成功匹配的结点
    private static ArrayList<Node> waiting1 = new ArrayList<>(); //TEG1已经成功匹配结点的子结点
    private static ArrayList<Node> waiting2 = new ArrayList<>(); //TEG2已经成功匹配结点的子结点

    public static void mergeTEGI(TEGI teg1, TEGI teg2){
        if(teg1.getEqualType() == 1 && teg2.getEqualType() == 2){ //teg1等式，teg2条件
            /*为条件teg添加AssertTrue操作结点*/
            for (Node node:teg2.getEntitySet()) {
                if(node.getChilds().size() == 0){
                    //为AssertTrue结点添加父结点
                    List<Node> parents = new ArrayList<Node>();
                    parents.add(teg2.getEnd());
                    //创建AssertTrue结点
                    Node assertTrue = new Node("AssertTrue", "", parents, null);
                    //为teg2结束结点添加子结点
                    teg2.getEnd().getChilds().add(assertTrue);
                    //创建结束结点和AssertTrue结点之间的边
                    Edge edge = new Edge(teg2.getEnd(),assertTrue,0,true);
                    //添加结点和边
                    teg2.getOptSet().add(assertTrue);
                    teg2.getEdgeSet().add(edge);
                }
            }
            /*合并两teg*/
            List<Node> teg1ZeroNodes = getIndegreeZeroNodes(teg1);
            List<Node> teg2ZeroNodes = getIndegreeZeroNodes(teg2);

            waiting1.addAll(teg1ZeroNodes);
            waiting2.addAll(teg2ZeroNodes);
            List<Node> removeOptNodes = new ArrayList<>();
            List<Node> removeEntityNodes = new ArrayList<>();
            List<Edge> removeEdges = new ArrayList<>();
            while(true){ //匹配相同结点
                List<Node> chd1 = new ArrayList<>();
                List<Node> chd2 = new ArrayList<>();
                for(Node node1 : waiting1){
                    for(Node node2 : waiting2){
                        if((node1.getParents().size()==0 && node2.getParents().size()==0) || isParentsMatchSucc(node1, node2)){
                            if(node1.getName().equals(node2.getName()) && node1.getDatatype().equals(node2.getDatatype())){
                                matchNode.put(node1, node2);
                                chd1.addAll(node1.getChilds());
                                chd2.addAll(node2.getChilds());

                                //移除结点
                                if(node2.getDatatype().equals("")){
                                    removeOptNodes.add(node2);
//                                    teg2.getOptSet().remove(node2);
                                }else {
                                    removeEntityNodes.add(node2);
//                                    teg2.getEntitySet().remove(node2);
                                }
                                //移除边
                                for(Edge edge : teg2.getEdgeSet()){
                                    if(edge.getHead() == node2){
                                        removeEdges.add(edge);
//                                        teg2.getEdgeSet().remove(edge);
                                    }
                                }
                            }
                        }
                    }
                }
                if(chd1.size() == 0 || chd2.size() == 0){
                    break;
                }
                waiting1.clear();
                waiting1.addAll(chd1);
                waiting2.clear();
                waiting2.addAll(chd2);
            }

            //融合
            teg2.getOptSet().removeAll(removeOptNodes);
            teg2.getEntitySet().removeAll(removeEntityNodes);
            teg2.getEdgeSet().removeAll(removeEdges);

            teg1.getEdgeSet().addAll(teg2.getEdgeSet());
            teg1.getEntitySet().addAll(teg2.getEntitySet());
            teg1.getOptSet().addAll(teg2.getOptSet());

            for(Node node:teg2.getOptSet()){//本身不在匹配集而父在匹配集,生成相关边
                if(!matchNode.containsValue(node)){
                    List<Node> nodePs = node.getParents();
                    if(nodePs.size() != 0){
                        for (int i = 0; i < nodePs.size(); i++){
                            Node n = nodePs.get(i);
                            if(matchNode.containsValue(n)){
                                Node key = null; //获取健
                                for(Map.Entry<Node, Node> mapEntry:matchNode.entrySet()){
                                    if(mapEntry.getValue()==n){
                                        key = mapEntry.getKey();
                                    }
                                }
                                if(key != null){
                                    teg1.getEdgeSet().add(new Edge(key,node, 0, true));
                                    System.out.println("添加边");
                                    node.getParents().remove(n);
                                    node.getParents().add(key);
                                    key.getChilds().add(node);

                                }
                            }
                        }
                    }
                }

            }

            /*连接AssertTrue结点和开始结点*/
            for(Node a:teg1.getOptSet()){
                if(a.getName().equals("AssertTrue")){
                    teg1.getEdgeSet().add(new Edge(a, teg1.getStart(), 0,true));
                    a.getChilds().add(teg1.getStart());
                }
            }
        }
    }

    //获取入度为0的结点集，
    private static List<Node> getIndegreeZeroNodes(TEGI tegi){
        List<Node> nodes = new ArrayList<Node>();
        for(Node node : tegi.getEntitySet()){
            if(node.getParents().size() == 0){
                nodes.add(node);
            }
        }
        return nodes;
    }

    public static boolean isParentsMatchSucc(Node node1, Node node2){
        for(Node node1Parent : node1.getParents()){
            for (Node node2Parent : node2.getParents()) {
                if(!matchNode.containsKey(node1Parent) || !matchNode.containsValue(node2Parent)){
                    return false;
                }
            }
        }
        return true;
    }
}
