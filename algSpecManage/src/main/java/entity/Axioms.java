package entity;


import entity.axiom.Equation;
import entity.axiom.GlobalVar;

import java.util.List;

/**
 * 公理
 *
 * @author Duyining
 * @date 2019/8/2
 */
public class Axioms {
    /**
     * 全局变量的声明
     */
    private GlobalVar globalVar;
    /**
     * 一个公理几个等式，之前好像都是只有一个
     */
    private List<Equation> equations;

    public GlobalVar getGlobalVar() {
        return globalVar;
    }

    public void setGlobalVar(GlobalVar globalVar) {
        this.globalVar = globalVar;
    }

    public List<Equation> getEquations() {
        return equations;
    }

    public void setEquations(List<Equation> equations) {
        this.equations = equations;
    }

    @Override
    public String toString() {
        return "Axioms{" +
                "globalVar=" + globalVar +
                ", equations=" + equations +
                '}';
    }

}
