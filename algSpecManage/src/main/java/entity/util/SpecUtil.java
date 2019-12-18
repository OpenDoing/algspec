package entity.util;

import entity.axiom.Conditions;
import entity.axiom.Equation;
import entity.axiom.Term;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *  规约结构提取工具类
 *
 * @author Zhuxu
 * @date 2019/8/25
 */
@Slf4j
public class SpecUtil {
    public static List<Equation> list = new ArrayList<Equation>();

    public static String divide(String s, String begin) {
        int beginIndex = s.indexOf(begin);
        int endIndex = s.indexOf("End");
        int[] index = new int[10];

        index[0] = s.indexOf("Spec");
        index[1] = s.indexOf("extends");
        index[2] = s.indexOf("uses");
        index[3] = s.indexOf("Attr");
        index[4] = s.indexOf("Const");
        index[5] = s.indexOf("Retr");
        index[6] = s.indexOf("Tran");
        index[7] = s.indexOf("Axiom");
        index[8] = s.indexOf("End");

        for (int i = 0; i < index.length - 1; i++) {
            if (index[i] > beginIndex) {
                if (index[i] < endIndex) {
                    endIndex = index[i];
                }
            }
        }
        String s1 = s.substring(beginIndex, endIndex);
        return s1;
    }

    /**
     * 拿到所有的公理
     * @param s
     * @return
     */
    public static List<String> getAxiomLine(String s) {
        String ss = "Axiom";
        if (!s.contains(ss)) {
            return null;
        }
        // Axiom 主体内容
        String s1 = s.substring(s.indexOf("Axiom")+5);

        String axioms = s1.substring(s1.indexOf("That") + 4,s1.indexOf("End"));
        System.out.println("axioms:"+axioms);

        String[] ax = axioms.split(";\n");

        handleAxioms(ax);

        return null;
    }

    /**
     * 分单条公理处理
     * @param ax
     */
    public static void handleAxioms(String[] ax) {
        for (String s :ax) {
            System.out.println("axiom:"+s);
        }

        for (int i = 0;i< ax.length;i++) {
            ax[i] = ax[i].trim();
            if (!"".equals(ax[i])){
                handleAxiom(ax[i]);
            }
        }
    }

    /**
     * 处理某一条公理
     * @param ax
     */
    public static void handleAxiom(String ax) {
        Equation equation = new Equation();
        // 包含，  代表有条件
        if (ax.contains("if")) {
            // 等式和条件有“，”分割
            int pos = ax.indexOf(",");
            String equ = ax.substring(0, pos);
            // 等式左边的项
            Term lterm = new Term();
            lterm.setTerm(handleEqu(equ)[0]);
            equation.setLterm(lterm);
            // 等式右边的项
            Term rterm = new Term();
            rterm.setTerm(handleEqu(equ)[1]);
            equation.setRterm(rterm);

            int conBegin = ax.indexOf("if");
            // +3的原因是从关键字if之后开始截取
            String condition = ax.substring(conBegin+3);
            equation.setConditions(handleConditions(condition));
        } else {
            // 等式左边的项
            Term lterm = new Term();
            lterm.setTerm(handleEqu(ax)[0]);
            equation.setLterm(lterm);
            // 等式右边的项
            Term rterm = new Term();
            rterm.setTerm(handleEqu(ax)[1]);
            equation.setRterm(rterm);
        }
        list.add(equation);
    }

    /**
     * 处理条件等式
     * @param conditions
     */
    private static List<Conditions> handleConditions(String conditions) {
//        System.out.println("consition:" + conditions);
        List<Conditions> conditionsList = new ArrayList<>();
        // 包含，  代表有多个条件
        if (conditions.contains(",")) {
            String [] conds = conditions.split(",");
            for (int i = 0;i< conds.length-1;i++) {
                Conditions cond = new Conditions();
                conds[i] = conds[i].trim();
                cond = handleCondition(conds[i]);
                conditionsList.add(cond);
            }
        }else {
            Conditions cond = new Conditions();
            cond = handleCondition(conditions);
            conditionsList.add(cond);
        }
        return conditionsList;
    }

    /**
     * 处理单个条件
     * @param condition
     */
    private static Conditions handleCondition(String condition) {
//        System.out.println("条件"+condition);
        Conditions conditions = new Conditions();
        // 正则更新，语法更新在这里配置
        String[] lr = condition.split(">=|=|<>|>|<|<=|≡");
        // 等式左边的项
        Term lterm = new Term();
        lterm.setTerm(lr[0]);
        conditions.setLterm(lterm);

        // 等式右边的项
        Term rterm = new Term();
        rterm.setTerm(lr[1]);
        conditions.setRterm(rterm);
        return conditions;
    }

    /**
     * 处理等式，不包含条件
     * @param equ
     */
    private static String[] handleEqu(String equ) {


        // 正则更新，语法更新在这里配置
        String[] lr = equ.split(">= | = | <> | > | < | ≡");
        return lr;
    }

    public static HashMap<String, Object> getAttr(String s) {
        String ss = "Attr";
        if (!s.contains(ss)) {
            return null;
        }
        HashMap<String, Object> m = new HashMap<>(1);
        String s1 = SpecUtil.divide(s, "Attr");
        String[] s2 = s1.split("\n");
        for (int i = 0; i < s2.length; i++) {
            s2[i] = s2[i].trim();
            if (s2[i].contains(":") && s2[i].contains(";")) {
                String ss1 = s2[i].substring(0, s2[i].indexOf(":"));
                String ss2 = s2[i].substring(s2[i].indexOf(":") + 1, s2[i].indexOf(";"));
                m.put(ss1, ss2);
            }
        }
        return m;
    }

    public static List<String> getConst(String s) {
        String ss = "Const";
        if (!s.contains(ss)) {
            return null;
        }
        ArrayList<String> l = new ArrayList<>();
        String s1 = SpecUtil.divide(s, "Const");
        s1 = s1.substring(0, s1.indexOf(";"));
        String[] s2 = s1.split(",");
        for (int i = 0; i < s2.length; i++) {
            s2[i] = s2[i].trim();
            l.add(s2[i]);
        }
        return l;
    }

    public static String getSpecName(String s) {
        String spec="Spec";
        String specRow= SpecUtil.divide(s,spec);
        String specname=specRow.substring(specRow.indexOf(spec)+4,specRow.indexOf(";"));
        return specname.trim();
    }


    public static List<String> getExtends(String s) {
        String ex = "extends";
        if (!s.contains(ex)) {
            return null;
        }
        ArrayList<String> l = new ArrayList<>();
        String exRow = SpecUtil.divide(s, ex);
        exRow = exRow.substring(exRow.indexOf(ex)+7, exRow.indexOf(";"));
        exRow=exRow.trim();
        String[] s2 = exRow.split(",");
        for (int i = 0; i < s2.length; i++) {
            s2[i] = s2[i].trim();
            l.add(s2[i]);
        }
        return l;
    }
    public static List<String> getUses(String s) {
        String us = "uses";
        if (!s.contains(us)) {
            return null;
        }
        ArrayList<String> l = new ArrayList<>();
        String usRow = SpecUtil.divide(s, us);
        usRow = usRow.substring(usRow.indexOf(us) + 4, usRow.indexOf(";"));
        usRow = usRow.trim();
        String[] s2 = usRow.split(",");
        for (int i = 0; i < s2.length; i++) {
            s2[i] = s2[i].trim();
            l.add(s2[i]);
        }
        return l;
    }

    public static void main(String[] args) {
        String s = "Spec ListofCase;\\n\" +\n" +
                "                \"\\tuses Case,Integer;\\n\" +\n" +
                "                \"\\tAttr\\n\" +\n" +
                "                \"\\t\\tcases[1..*]:Case;\\n\" +\n" +
                "                \"\\t\\tlength:Integer;\\n\" +\n" +
                "                \"\\tAxiom\\n\" +\n" +
                "                \"\\t\\tFor all lc:ListOfCase, c1,c2:Case That\\n\" +\n" +
                "                \"\\t\\t\\tlc.length >= 0;\\n\" +\n" +
                "                \"\\t\\t\\tlc.cases = null, if lc.length = 0;\\n\" +\n" +
                "                \"\\t\\t\\tlc.cases <> null , if lc.length > 0;\\n\" +\n" +
                "                \"\\t\\tEnd\\n\" +\n" +
                "                \"End\\t";
//        String ss= SpecUtil.getSpecName(s);
//        List<HashMap<String, Object>> l1 = SpecUtil.getAttr(s);
//        List<String> l2 = SpecUtil.getConst(s);
//        List<String>l3= SpecUtil.getExtends(s);
//        List<String>l4= SpecUtil.getUses(s);
//        System.out.println(ss);
//        System.out.println(l1);
//        System.out.println(l2);
//        System.out.println(l3);
//        System.out.println(l4);

//        System.out.println("000000000");
//        String axiom = SpecUtil.divide(s, "Axiom");
//        System.out.println(axiom);

        SpecUtil.getAxiomLine(s);
        System.out.println(list.size());
        System.out.println(list.get(0).getRterm().getTerm().trim());
        System.out.println(list.get(1).getRterm().getTerm().trim());
        System.out.println(list.get(2).getRterm().getTerm().trim());
        System.out.println(list.get(1).getConditions().get(0).getRterm().getTerm());
        System.out.println(list.get(2).getConditions().get(0).getRterm().getTerm());
        System.out.println(list.size());
    }
}