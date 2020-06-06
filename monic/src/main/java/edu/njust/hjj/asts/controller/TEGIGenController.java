package edu.njust.hjj.asts.controller;

import edu.njust.hjj.asts.bean.Node;
import edu.njust.hjj.asts.bean.TEGI;
import edu.njust.hjj.asts.dao.TermMapper;
import edu.njust.hjj.asts.service.MTSGenService;
import edu.njust.hjj.asts.service.OperationService;
import edu.njust.hjj.asts.service.TEGIGenService;
import edu.njust.hjj.asts.service.TermService;
import edu.njust.hjj.asts.util.GraphVizUtil;
import edu.njust.hjj.asts.util.MergeTEGIUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
public class TEGIGenController {

    @Autowired
    TEGIGenService operationService;

    @Autowired
    MTSGenService mtsGenService;

    @Autowired
    TermService termService;

    /**
     * 等式化处理接口
     * @param tc 输入的测试用例
     * @return 等式化处理结果
     */
    @RequestMapping("/isEqProc")
    @ResponseBody
    public String isEqProc(String tc){
        String isEqTerm = "";
//        String [] temps = tc.split(",if");
//        for(int i = 0; i< temps.length; i++){
//            temps[i] = "isEq("+temps[i].replace("=",",")+")";
//            temps[i].replace(" ","");
//            if(temps.length == 1){
//                isEqTerm = isEqTerm+temps[i];
//            }else{
//                if(i == 0){
//                    isEqTerm = isEqTerm+temps[i]+",if ";
//                }
//                else if(i == 1){
//                    isEqTerm = isEqTerm+temps[i];
//                }
//                else {
//                    isEqTerm = isEqTerm+","+temps[i];
//                }
//            }
//        }
        return isEqTerm;
    }

    /**
     * TEGI生成接口
     */
    @RequestMapping("/getTEGI")
    @ResponseBody
    public void getTEGI(String isEqtc){
        String [] temps = isEqtc.split(", if ");
        for(int i = 0; i < temps.length; i++){
            System.out.println(temps[i]);
        }
//        temps[0] = "isEq(top(pop(pop(push(st,1)))),top(pop(st)))";
        List<String> tc = new ArrayList<String>();
        tc.add(temps[0]);
        TEGI tegi = new TEGI();
        operationService.generateTEG(tegi,"Stack", tc, 1, true);
        //添加逆项TEG
        List<String> termdb = termService.findAllTerm();
        String iterm = null;
        for(String t : termdb){
            for(String str : tc) {
                if (str.indexOf(t) != -1) {
                    iterm = termService.findIterm(t);
                    if (iterm != null) {
                        operationService.generateTEGI(tegi, "Stack", iterm, false);
                    }
                }
            }
        }
        tegi.setEqualType(1);
        GraphVizUtil.toPNG(tegi,"tegi");

        //添加条件TEG并合并
        if(temps.length == 2){
            TEGI ctegi = new TEGI();
            List<String> ce = new ArrayList<>();
//            temps[1] = "isEq(isG(length(st),0),true)";
            ce.add(temps[1]);
            operationService.generateTEG(ctegi,"Stack", ce, 2, true);
            ctegi.setEqualType(2);

            for(Node cNode:ctegi.getEntitySet()){
                if(cNode.getParents().size()==0 && cNode.getDatatype().equals(ctegi.getSpec())){
                    System.out.println("开始结点："+ ctegi.getStart().getName()+":"+ctegi.getStart().getDatatype());
                    ctegi.setStart(cNode);
                }else if(cNode.getChilds().size()==0){
                    ctegi.setEnd(cNode);
                }
            }
            MergeTEGIUtil.mergeTEGI(tegi, ctegi);
            GraphVizUtil.toPNG(tegi,"tegi");
        }
        //生成单线测试序列
        mtsGenService.generateMTS(tegi);
    }
}
