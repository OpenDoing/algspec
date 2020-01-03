package entity.build;


import entity.Spec;

/**
 * 建造者模式，定义建造骨架
 *
 * @author Duyining
 * @date 2019/8/21
 */
public abstract class AbstractBuilder {

    /**
     * build Spec Name
     * @param spec 规约
     */
    abstract void buildSname(String spec);

    /**
     * build extendsSort
     * @param spec 规约
     */
    abstract void buildextends(String spec);

    /**
     * build usesType
     * @param spec 规约
     */
    abstract void buildUsesType(String spec);

    /**
     * build signature
     * @param spec 规约
     */
    abstract void buildSignature(String spec);

    /**
     * build axioms
     * @param spec 规约
     */
    abstract void buildAxioms(String spec);

    /**
     * 返回构建的结果
     * @return
     */
    abstract Spec getSort();
}
