package edu.njust.hjj.asts.serviceImpl;

import edu.njust.hjj.asts.bean.Edge;
import edu.njust.hjj.asts.bean.Node;
import edu.njust.hjj.asts.bean.Operation;
import edu.njust.hjj.asts.bean.TEGI;
import edu.njust.hjj.asts.service.OperationService;
import edu.njust.hjj.asts.service.TEGIGenService;
import edu.njust.hjj.asts.util.TermProcUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * TEGI生成
 */
@Service
public class TEGIGenServiceImpl implements TEGIGenService{

    @Autowired
    OperationService operationService;

    /**
     * 生成TEG
     * @param tegi
     * @param specName 规约名
     * @param termList 项列表
     * @param equalType  等式类型（等式或条件）
     * @param edgType 边类型（实线或虚线）
     * @return   操作的参数实体结点集
     */
    @Override
    public List<Node> generateTEG(TEGI tegi, String specName, List<String> termList, int equalType, boolean edgType){
        List<Node> argNodes = new ArrayList<Node>(); //项列表最外层的实体结点

        //为常量和变量生成实体结点
        for(String cvStr : TermProcUtil.getCvList(termList)) {
            String cvType = operationService.getFirstRtType(cvStr);
            if(cvType == null){ //变量or常量不存在
                System.out.println(cvStr+"不存在！");
            }
            //构造一个实体结点
            Node entityNode = new Node(cvStr, cvType,null,null);
            Node eSameNode = isInNodeList(entityNode, tegi.getEntitySet());//查询结点列表中是否存在某个结点，不存在，返回空；存在，返回存在的结点
            if(eSameNode == null){
                tegi.getEntitySet().add(entityNode);  //将实体节点添加到TEGI的实体节点集
                if(cvType.equals(specName)){
                    tegi.setStart(entityNode);
                    tegi.setSpec(specName);
                }
                argNodes.add(entityNode);             //参数结点
            }else {
                argNodes.add(eSameNode);              //参数结点???
            }
        }

        //列表中没有操作，表示递归结束
        if(TermProcUtil.getOptList(termList).size() == 0){
            return argNodes;
        }
        //为列表中的操作构造执行图
        else{
            for(String optStr : TermProcUtil.getOptList(termList)){
                List<String> optArgList = TermProcUtil.getOptArgList(optStr);//存储操作的参数列表
                List<Node> optArgEntityNodes = generateTEG(tegi,specName,optArgList,equalType, edgType);//为参数列表生成TEG

                //构造操作结点
                String optName = TermProcUtil.getOptName(optStr);
                Node optNode = new Node(optName,"",optArgEntityNodes,null);
                Node oSameNode = isInNodeList(optNode, tegi.getOptSet());//判断操作节点是否在操作集合中
                Operation optInfo = null;
                optInfo = operationService.getOpt(optName); //查询操作信息
                if(oSameNode == null){
                    tegi.getOptSet().add(optNode);
                    if(optInfo == null){
                        System.out.println(optName + "操作不存在");
                    }else{ //设置操作权限
                        if(optInfo.getOptType().equals("trans")){
                            if(edgType){ //边类型是实线
                                optNode.setPriority(1);
                            }else { //边类型是虚线
                                optNode.setPriority(0);
                            }
                        }
                        else if(optInfo.getOptType().equals("retri")){
                            optNode.setPriority(2);
                        }else if(optInfo.getOptType().equals("attr")){
                            optNode.setPriority(3);
                        }
                    }
                }

                List<Node> parents = new ArrayList<Node>();
                if(oSameNode == null){
                    parents.add(optNode);
                }else{
                    parents.add(oSameNode);
                }
                if(optInfo == null){
                    System.out.println(optName + "操作不存在");
                }
                Node rtNode = new Node("-", optInfo.getRetDT().get(0),parents,null); //若操作不存在，程序异常崩溃


                if(oSameNode == null){  //添加操作返回的实体结点
                    tegi.getEntitySet().add(rtNode);
                    argNodes.add(rtNode);  //
                }
                else{ //实体结点在TEG的结点集中??
                    argNodes.addAll(oSameNode.getChilds());
                }

                //添加边
                if(oSameNode == null){
                    int order = 0;
                    for(Node eNode:optArgEntityNodes){ //参数和操作连接
                        eNode.getChilds().add(optNode);
                        Edge e_oEdge = new Edge(eNode,optNode,order++, edgType);
                        tegi.getEdgeSet().add(e_oEdge);
                    }

                    //操作和返回连接
                    optNode.getChilds().add(rtNode);
                    Edge o_eEdge = new Edge(optNode,rtNode,0, edgType);
                    tegi.getEdgeSet().add(o_eEdge);
                }
            }
        }
        return argNodes;
    }

    /**
     * 生成逆项TEG,组成一个项的TEG-I
     * @param tegi  TEG
     * @param specName 规约名
     * @param term  逆项
     * @param edgType 边类型
     */
    public void generateTEGI(TEGI tegi, String specName, String term, boolean edgType){
        List<String> termList = new ArrayList<String>();
        termList.add(term);
        generateTEG(tegi,specName, termList, -1,false); //添加逆操作

        //获取项的开始结点
        Node start = null;
        for(Node n : tegi.getEntitySet()){
            if(!n.getName().equals("-") && n.getDatatype().equals(specName)){
                start = n;
            }
        }

        //获取逆项的结束结点，并将其删除
        Node iend = null;
        for (int i = tegi.getEntitySet().size()-1; i >=0 ; i--) {
            Node n = tegi.getEntitySet().get(i);
            if(n.getChilds().size() == 0 && n.getDatatype().equals(specName)){
                iend = n;
                for(Node node : tegi.getOptSet()){
                    if(node.getChilds().contains(n)){
                        node.getChilds().remove(n);
                        node.getChilds().add(start);
                    }
                }
                tegi.getEntitySet().remove(n);
            }
        }

        //将逆项的结束结点和项的开始结点组成边
        if (iend != null && start != null) {
            for(Edge e : tegi.getEdgeSet()){
                if(e.getTail() == iend ){
                    e.setTail(start);
                }
            }
        }else{
            System.out.println("逆项图生成失败");
        }

    }

    /**
     * 查询结点列表中是否存在某个结点，不存在，返回空；存在，返回存在的结点
     * @param node
     * @param nodeList
     * @return
     */
    private Node isInNodeList(Node node, List<Node> nodeList){
        for(int i = 0; i < nodeList.size(); i++){
            if(nodeList.get(i).equals(node)){
                return nodeList.get(i);
            }
        }
        return null;
    }

    /**
     *
     * @param tegi
     * @param tail
     * @return 返回以操作结点为尾的边
     */
    private Edge findOptTailEdge(TEGI tegi, Node tail){
        Edge edge = null;
        for(Edge e:tegi.getEdgeSet()){
            if(e.getTail() == tail){
                edge = e;
            }
        }
        return edge;
    }

}
