package edu.njust.hjj.asts.serviceImpl;

import edu.njust.hjj.asts.bean.Edge;
import edu.njust.hjj.asts.bean.Node;
import edu.njust.hjj.asts.bean.Operation;
import edu.njust.hjj.asts.bean.TEGI;
import edu.njust.hjj.asts.service.MTSGenService;
import edu.njust.hjj.asts.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Args类记录操作已访问的参数结点和未访问的参数结点
 */
class Args{
    private Set<Node> Es; //已访问的参数结点
    private Set<Node> NEs; //未访问的参数结点

    public Args(Set<Node> Es, Set<Node> NEs) {
        this.Es = Es;
        this.NEs = NEs;
    }

    public Set<Node> getEs() {
        return Es;
    }

    public void setEs(Set<Node> es) {
        Es = es;
    }

    public Set<Node> getNEs() {
        return NEs;
    }

    public void setNEs(Set<Node> NEs) {
        this.NEs = NEs;
    }
}

/**
 * 单线测试序列生成
 */
@Service
public class MTSGenServiceImpl implements MTSGenService{

    @Autowired
    OperationService operationService;

    /**
     * 单线测试序列生成函数，单线测试序列生成算法的代码实现
     * @param tegi
     */
    @Override
    public void generateMTS(TEGI tegi) {
        /**初始化列表**/
        LinkedList<Node> LE = new LinkedList<Node>();  //双向链表，在链表头尾可以实现增删
        LE.add(tegi.getStart()); //将teg的开始结点加入双链表
        LE.addAll(getIndegreeZero(tegi));  //将除开始结点以外的所有入度为0的结点加入双链表


        /**notVistedChdOpts记录实体结点未访问的子结点（操作结点），初始时所有子结点都未访问**/
        Map<Node, List<Node>> notVistedChdOpts = new HashMap<>();
        for(Node n : tegi.getEntitySet()){
            notVistedChdOpts.put(n, n.getChilds());
        }

        /**labelMap记录每个实体结点在测试序列中对应的名字**/
        Map<Node, String> labelMap = new HashMap<>();
        int count = 0;

        /**记录访问到的操作结点及其访问过和未访问的参数结点**/
        Map<Node, Args> OP = new HashMap<Node, Args>(); //处理中操作结点集

        /**生成测试序列**/
        while (true){
            //获取实体结点列表头元素，并将其从列表移除
            Node ce = LE.getFirst();
            LE.removeFirst();

            //为实体结点标记测试序列中对应的名称
            if(!labelMap.containsKey(ce)){ //增加label和结点映射
                if(ce.getName().equals("-")){
                    labelMap.put(ce,"_"+(++count));
                }else{
                    labelMap.put(ce, ce.getName());
                }
            }

            List<Node> notVistedChd = notVistedChdOpts.get(ce);//获取实体未访问的孩子结点
            Node cop = getPriority(notVistedChd);  //取优先级最高的孩子结点（操作）
            if(ce.getChilds().size() == 0) return;  //若实体结点出度为0，程序运行结束
            if(cop == null) continue; //若操作结点为空，进入下一次循环

            Operation operation = operationService.getOpt(cop.getName());  //获取操作的信息

            if(!operation.getOptType().equals("trans")
                    && notVistedChd.size() > 1){  //如果操作不是转换操作且实体未访问的子操作大于1，将结点加入链表尾
                LE.addLast(ce);
            }else if(operation.getOptType().equals("trans")
                    && !operation.getOptBelong().equals(ce.getDatatype())
                    && notVistedChd.size() > 1){  //如果操作是转换操作但操作不是实体结点类子的操作且实体未访问的子操作大于1，将结点加入链表尾
                LE.addLast(ce);
            }

            //操作的入度为1，生成操作序列
            if(cop.getParents().size() == 1){
                if(!labelMap.containsKey(cop.getChilds().get(0))){  //增加label和结点映射
                    if(cop.getChilds().get(0).getName().equals("-")){
                        labelMap.put(cop.getChilds().get(0),"_"+(++count));
                    }else{
                        labelMap.put(cop.getChilds().get(0), cop.getChilds().get(0).getName());
                    }
                }
                sortArgs(tegi,cop.getParents());  //排序参数结点
                genCode(cop, labelMap);  //生成操作序列
                if(!cop.getName().equals("AssertTrue")){  //如果操作不是AssertTrue，则将操作的返回值结点加入双链表头
                    LE.addFirst(cop.getChilds().get(0));
                }


            }
            else{//操作入度大于1
                if(!OP.containsKey(cop)){ //如果操作不在处理中操作结点集，则将其加入处理中结点集并更新其已处理参数集和未处理参数集
                    Set<Node> Es = new HashSet<>();  //将ce加入cop的已处理参数集
                    Es.add(ce);
                    Set<Node> NEs = new HashSet<>();  //将ce以外的结点加入cop未处理结点集
                    for(Node n : cop.getParents()){
                        if(!(n == ce)){ //Node的equals重写了
                            NEs.add(n);
                        }
                    }
                    OP.put(cop,new Args(Es,NEs)); //cop加入处理中操作集，更新其已处理和未处理父结点集
                }
                else{//若操作在处理中操作结点集，更新其已处理参数结点集和未处理参数结点集
                    Args args = OP.get(cop);
                    args.getEs().add(ce);
                    args.getNEs().remove(ce);
                    if(args.getNEs().size() == 0){  //若未处理参数结点集为空，生成操作序列，将其从处理中操作结点集移除，并将其孩子结点加入双链表头
                        if(!labelMap.containsKey(cop.getChilds().get(0))){  //增加label和结点映射
                            if(cop.getChilds().get(0).getName().equals("-")){
                                labelMap.put(cop.getChilds().get(0),"_"+(++count));
                            }else{
                                labelMap.put(cop.getChilds().get(0), cop.getChilds().get(0).getName());
                            }
                        }
                        sortArgs(tegi,cop.getParents()); //排序参数结点
                        genCode(cop, labelMap); //生成操作序列
                        LE.addAll(0,cop.getChilds());
                        OP.remove(cop);
                    }
                }
            }
            notVistedChdOpts.get(ce).remove(cop); //将cop从ce的未访问子结点集中移除
        }


    }

    /**
     * 获取入度为0的结点（不包括开始结点）
     * @param tegi
     * @return
     */
    private List<Node> getIndegreeZero(TEGI tegi){
        List<Node> retList = new ArrayList<Node>();
        for (Node n : tegi.getEntitySet()){
            if(n.getParents().size() == 0 && n != tegi.getStart()){
                retList.add(n);
            }
        }
        return retList;
    }

    /**
     * 获取列表中优先级最高的操作结点
     * @param list
     * @return
     */
    private Node getPriority(List<Node> list){
        if(list.size() == 0){
            System.out.println("列表为空");
            return null;
        }
        Node n = list.get(0);
        for(Node node:list){
            if(n.getPriority() < node.getPriority()){
                n = node;
            }
        }
        return n;
    }


    /**
     * 生成测试序列
     * @param opt
     * @param labelMap
     */
    private void genCode(Node opt, Map<Node, String> labelMap){
       String args = labelMap.get(opt.getParents().get(0));
       for(int i = 1; i < opt.getParents().size(); i++){ //参数
           args = args + "," + labelMap.get(opt.getParents().get(i));
       }
       if(opt.getName().equals("AssertTrue")){
            System.out.println(opt.getName() + "("+args+")");
       }else{
           String rt = labelMap.get(opt.getChilds().get(0));
           System.out.println(rt + "=" + opt.getName()+ "("+args+")");
       }
    }

    /**
     * 对参数结点排序
     * @param args
     */
    private void sortArgs(TEGI tegi, List<Node> args){
        for(int i = 0; i < args.size()-1; i++){
            for(int j = 0; j<args.size()-1-i; j++){
                if(findArgHeadEdge(tegi,args.get(j)).getOrder() >
                        findArgHeadEdge(tegi,args.get(j+1)).getOrder()){
                    Node temp = args.get(j);
                    args.set(j,args.get(j+1));
                    args.set(j+1,temp);
                }
            }
        }
    }

    /**
     *
     * @param tegi
     * @param head
     * @return 返回以参数结点为头的边
     */
    private Edge findArgHeadEdge(TEGI tegi, Node head){
        Edge edge = null;
        for(Edge e:tegi.getEdgeSet()){
            if(e.getHead() == head){
                edge = e;
            }
        }
        return edge;
    }
}
