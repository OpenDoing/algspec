package entity.axiom;

import java.util.List;

/**
 * 全局变量
 *
 * @author Duyining
 * @date 2019/8/2
 */
public class GlobalVar {
    private List<Var> gvars;

    public List<Var> getGvars() {
        return gvars;
    }

    public void setGvars(List<Var> gvars) {
        this.gvars = gvars;
    }

    @Override
    public String toString() {
        return "GlobalVar{" +
                "gvars=" + gvars +
                '}';
    }
}
