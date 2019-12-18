package entity;

import java.util.List;

/**
 * 用户名下的包，也就是规约文档
 *
 * @author Duyining
 * @date 2019/8/21
 */
public class UserSpec {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户拥有的规约文档
     */
    private List<SpecPackage> docs;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<SpecPackage> getDocs() {
        return docs;
    }

    public void setDocs(List<SpecPackage> docs) {
        this.docs = docs;
    }

    @Override
    public String toString() {
        return "UserSpec{" +
                "userName='" + userName + '\'' +
                ", docs=" + docs +
                '}';
    }
}
