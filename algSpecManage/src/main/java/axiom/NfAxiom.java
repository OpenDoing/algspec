package axiom;

import entity.axiom.Equation;
import entity.axiom.Term;
import entity.util.SpecUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * comment here
 *
 * @author Duyining
 * @date 2019/10/29
 */
public class NfAxiom {

    public static void run(List<Equation> axioms,List<Term> nfset) {
        repSort(axioms,nfset);
    }

    public static List<Equation> getAxiomEqu(String axioms) {
        String[] ax = axioms.split(";\n");
        int len = ax.length;
        System.out.println("公理共有："+len+" 条");
        for (String s:ax){
            System.out.println(s);
        }
        SpecUtil.handleAxioms(ax);
        return SpecUtil.list;
    }

    public static List<Term> getNoramlForms(String nfset) {
        nfset = nfset.trim();
        String[] forms = nfset.split("\n");
        int len = forms.length;
        System.out.println("范式集共有："+len+" 条");
        if (len==0){
            return null;
        }
        List<Term> list = new ArrayList<>();
        Term[] terms = new Term[len];
        for (int i = 0;i<len;i++){
            Term term = new Term();
            term.setTerm(forms[i]);
            list.add(term);
//            terms[i] = term;
        }
        return list;
    }

    /**
     * 判断公理的开始  是否是类变量 范式替换的前提
     * @param term 公理等式第一次；或者.出现之前的字符串
     * @return true or false
     */
    public static boolean isSortVar(Term term) {
        String var = getSortVar(term);
        if (!"nil".equals(var)) {
            return true;
        }
        return false;
    }

    /**
     * 获取公理的首个var，可以是类var，可以是const
     * @param term 项
     * @return 公理的首个var
     */
    private static String getSortVar(Term term) {
        int index = 0;
        String s = term.getTerm().trim();
        int fenhao = s.indexOf(';');
        int dot = s.indexOf('.');
        if (fenhao >0&& dot>0){
            index = fenhao>dot?dot:fenhao;
        } else if (fenhao == -1 && dot == -1){
            index = 1;
        } else if (fenhao == -1){
            index = dot;
        } else if (dot == -1){
            index = fenhao;
        }
//        System.out.println("类变量"+s.substring(0,index));
        return s.substring(0,index);
    }

    /**
     * 输入公理集和范式集，输出范式替换公理的结果集
     * @param equs 公理
     * @param terms 范式
     * @return 范式替换的公理
     */
    public static List<String> repSort(List<Equation> equs,List<Term> terms) {
//        System.out.println(equs.size());
        List<String> list = new ArrayList<>();
        for (Equation equation:equs) {
            for (Term term: terms) {
                // 公理不包含类变量
                if (!isSortVar(equation.getLterm())) {
                    break;
                }
                list.add(replace(equation,term));
            }
        }
        return list;
    }

    /**
     * 对于单条公理的替换
     * @param equation 公理等式
     * @param term 范式
     * @return 范式替换公理类变量的结果
     */
    private static String replace(Equation equation, Term term) {
        Term lt = equation.getLterm();
        Term rt = equation.getRterm();
        String let = lt.getTerm();
        String lresult = let.replaceFirst(getSortVar(lt), term.getTerm());
        System.out.println("左边term替换结果："+lresult);

        String ret = rt.getTerm();
        String rresult = ret.replaceFirst(getSortVar(rt), term.getTerm());
        System.out.println("右边term替换结果："+rresult);

        Term nlt = new Term();
//        nlt.setTerm();
        return "";
    }

    /**
     * 用范式替换项的类变量
     * @param term 项
     * @param form 范式
     */
    public String nf2var(Term term,Term form) {
        String let = term.getTerm();
        // 有类变量才需要替换
        if (isSortVar(term)) {
            String result = let.replaceFirst(getSortVar(term), form.getTerm());
            return result;
        }
        // 没有类变量不用替换
        return let;
    }


}
