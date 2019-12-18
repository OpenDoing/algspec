package entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * 对应一个文件，这里是包的概念，一个包有若干个spec类子
 *
 * @author Duyining
 * @date 2019/8/21
 */
@Document(collection = "spec")
public class SpecPackage {
    /**
     * 规约文档的包名
     */
    private String packageName;
    /**
     * 某个包下面的所有类子
     */
    private List<Spec> specs;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public List<Spec> getSpecs() {
        return specs;
    }

    public void setSpecs(List<Spec> specs) {
        this.specs = specs;
    }

    @Override
    public String toString() {
        return "SpecPackage{" +
                "packageName='" + packageName + '\'' +
                ", specs=" + specs +
                '}';
    }
}
