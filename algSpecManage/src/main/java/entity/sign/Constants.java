package entity.sign;

import java.util.List;

/**
 * 一系列类型为当前类子的常量,
 * 常量之间用逗号分隔
 *
 * @author Duyining
 * @date 2019/8/2
 */
public class Constants {
    private List<String> consts;

    public List<String> getConsts() {
        return consts;
    }

    public void setConsts(List<String> consts) {
        this.consts = consts;
    }

    @Override
    public String toString() {
        return "Constants{" +
                "consts=" + consts +
                '}';
    }
}
