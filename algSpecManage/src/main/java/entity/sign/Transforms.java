package entity.sign;

import java.util.List;

/**
 * 改变状态的操作
 *
 * @author Duyining
 * @date 2019/8/2
 */
public class Transforms {
    private List<Operation> trans;

    public List<Operation> getTrans() {
        return trans;
    }

    public void setTrans(List<Operation> trans) {
        this.trans = trans;
    }

    @Override
    public String toString() {
        return "Transforms{" +
                "trans=" + trans +
                '}';
    }
}
