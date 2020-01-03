package entity.build;

import entity.Axioms;
import entity.Signature;
import entity.Spec;
import entity.sign.Attributes;
import entity.sign.Constants;
import entity.sign.Retrieves;
import entity.sign.Transforms;
import entity.util.SignUtil;
import entity.util.SpecUtil;

import java.util.ArrayList;

/**
 * 构建类子实现类
 *
 * @author Duyining
 * @date 2019/8/21
 */
public class SpecBuilder extends AbstractBuilder{
    private Spec sort = new Spec();

    @Override
    void buildSname(String spec) {
        String name = SpecUtil.getSpecName(spec);
        sort.setSpecName(name);
    }

    @Override
    void buildextends(String spec) {
        sort.setExtendsSort(SpecUtil.getExtends(spec));
    }

    @Override
    void buildUsesType(String spec) {
        sort.setUsesType(SpecUtil.getUses(spec));
    }

    @Override
    void buildSignature(String spec) {
        Signature signature = new Signature();
        // Attr
        Attributes attributes = new Attributes();
        attributes.setAttrs(SpecUtil.getAttr(spec));
        signature.setAttributes(attributes);

        // const
        Constants constants = new Constants();
        constants.setConsts(SpecUtil.getConst(spec));
        signature.setConstants(constants);

        // Retr
        Retrieves retrieves = new Retrieves();
        retrieves.setRetrs(SignUtil.getRetr(spec));
        signature.setRetrieves(retrieves);

        // Tran
        Transforms transforms = new Transforms();
        transforms.setTrans(SignUtil.getTran(spec));
        signature.setTransforms(transforms);

        sort.setSignature(signature);
    }

    @Override
    void buildAxioms(String spec) {
        SpecUtil.getAxiomLine(spec);
        Axioms axioms = new Axioms();
        // 等式,实现放在工具类里面了。。。
        axioms.setEquations(SpecUtil.list);
        sort.setAxioms(axioms);
        // list置空，否则公理会不停叠加，不可为null
        // 因为是静态变量，插入数据库会叠加
        SpecUtil.list = new ArrayList<>();
    }

    @Override
    Spec getSort() {
        return sort;
    }
}
