package entity.sign;

import java.util.List;

/**
 * 不改变状态的检索操作
 *
 * @author Duyining
 * @date 2019/8/2
 */
public class Retrieves {
    private List<Operation> retrs;

    public List<Operation> getRetrs() {
        return retrs;
    }

    public void setRetrs(List<Operation> retrs) {
        this.retrs = retrs;
    }

    @Override
    public String toString() {
        return "Retrieves{" +
                "retrs=" + retrs +
                '}';
    }
}
