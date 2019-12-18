package entity.axiom;

import java.util.List;

/**
 * 公理的等式
 *
 * @author Duyining
 * @date 2019/8/2
 */
public class Equation {
    /**
     * 等式左边的项
     */
    private Term lterm;
    /**
     * 等式右边的项
     */
    private Term rterm;
    /**
     * 两个项之间的关系
     */
    private Relation relation;
    /**
     * 条件，大于等于0个
     */
    private List<Conditions> conditions;

    public Term getLterm() {
        return lterm;
    }

    public void setLterm(Term lterm) {
        this.lterm = lterm;
    }

    public Term getRterm() {
        return rterm;
    }

    public void setRterm(Term rterm) {
        this.rterm = rterm;
    }

    public Relation getRelation() {
        return relation;
    }

    public void setRelation(Relation relation) {
        this.relation = relation;
    }

    public List<Conditions> getConditions() {
        return conditions;
    }

    public void setConditions(List<Conditions> conditions) {
        this.conditions = conditions;
    }

    @Override
    public String toString() {
        return "Equation{" +
                "lterm=" + lterm +
                ", rterm=" + rterm +
                ", relation=" + relation +
                ", conditions=" + conditions +
                '}';
    }
}
