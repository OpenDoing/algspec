package entity.axiom;

/**
 * 公理的条件，非必须，类同等式Equation
 *
 * @author Duyining
 * @date 2019/8/2
 */
public class Conditions {
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
    private String relation;

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

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    @Override
    public String toString() {
        return "Conditions{" +
                "lterm=" + lterm +
                ", rterm=" + rterm +
                ", relation=" + relation +
                '}';
    }
}
