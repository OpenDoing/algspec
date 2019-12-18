package entity.axiom;

import entity.Signature;

import java.util.List;

/**
 * 项，一条语句即为一个项
 * @author Duyining
 * @date 2019/8/2
 */
public class Term {
    /**
     * 实例变量
     */
    private Var var;
    /**
     * 操作列表，这里采用List是因为操作是有顺序的
     */
    private List<Signature> signs;

    /**
     * 临时方案，项以String的形式保存，不进行二次拆分
     */
    private String term;

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Var getVar() {
        return var;
    }

    public void setVar(Var var) {
        this.var = var;
    }

    public List<Signature> getSigns() {
        return signs;
    }

    public void setSigns(List<Signature> signs) {
        this.signs = signs;
    }

    @Override
    public String toString() {
        return "Term{" +
                "var=" + var +
                ", signs=" + signs +
                ", term='" + term + '\'' +
                '}';
    }
}
