package entity.build;

/**
 * 构造公理抽象类
 *
 * @author Duyining
 * @date 2019/10/15
 */
public abstract class AbstractaAxiomBuilder {

    /**
     * 等式
     * @param spec
     */
    abstract void buildEqu(String spec);

    /**
     * 构造等式关系
     * @param spec
     */
    abstract void buildRealation(String spec);

    /**
     * 构造条件等式
     * @param spec
     */
    abstract void buildConditions(String spec);
}
