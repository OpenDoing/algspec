package entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * 类子
 *
 * @author Duyining
 * @date 2019/8/2
 */
public class Spec {
    //标记id字段
    @Id
    private ObjectId id;
    /**
     * 类子名称
     */
    private String specName;
    /**
     * 继承关系
     */
    private List<String> extendsSort;
    /**
     * 使用关系
     */
    private List<String> usesType;
    /**
     * 基调方法
     */
    private Signature signature;
    /**
     * 公理
     */
    private Axioms axioms;

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public List<String> getExtendsSort() {
        return extendsSort;
    }

    public void setExtendsSort(List<String> extendsSort) {
        this.extendsSort = extendsSort;
    }

    public List<String> getUsesType() {
        return usesType;
    }

    public void setUsesType(List<String> usesType) {
        this.usesType = usesType;
    }

    public Signature getSignature() {
        return signature;
    }

    public void setSignature(Signature signature) {
        this.signature = signature;
    }

    public Axioms getAxioms() {
        return axioms;
    }

    public void setAxioms(Axioms axioms) {
        this.axioms = axioms;
    }

    @Override
    public String toString() {
        return "Spec{" +
                "specName='" + specName + '\'' +
                ", extendsSort=" + extendsSort +
                ", usesType=" + usesType +
                ", signature=" + signature +
                ", axioms=" + axioms +
                '}';
    }
}
