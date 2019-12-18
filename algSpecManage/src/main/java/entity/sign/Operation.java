package entity.sign;

import java.util.List;

/**
 * 操作，Transforms和Retrieves都是这个数据结构
 *
 * @author Duyining
 * @date 2019/8/2
 */
public class Operation {
    private String opName;
    private List<Object> domainsType;
    private List<Object> codomainsType;

    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }

    public List<Object> getDomainsType() {
        return domainsType;
    }

    public void setDomainsType(List<Object> domainsType) {
        this.domainsType = domainsType;
    }

    public List<Object> getCodomainsType() {
        return codomainsType;
    }

    public void setCodomainsType(List<Object> codomainsType) {
        this.codomainsType = codomainsType;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "opName='" + opName + '\'' +
                ", domainsType=" + domainsType +
                ", codomainsType=" + codomainsType +
                '}';
    }
}
