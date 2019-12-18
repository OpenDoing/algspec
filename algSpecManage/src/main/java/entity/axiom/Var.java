package entity.axiom;

import java.util.HashMap;

/**
 * 单个变量，这里单独拆开是因为为了项Term的声明
 *
 * @author Duyining
 * @date 2019/8/2
 */
public class Var {
    /**
     * string 保存变量名 ,Object save Spec
     */
    private HashMap<String,Object> var;

    public HashMap<String, Object> getVar() {
        return var;
    }

    public void setVar(HashMap<String, Object> var) {
        this.var = var;
    }

    @Override
    public String toString() {
        return "Var{" +
                "var=" + var +
                '}';
    }
}
