package entity.build;


import entity.Spec;

import java.io.IOException;

/**
 * comment here
 *
 * @author Duyining
 * @date 2019/8/21
 */
public class SpecDirector {
    private AbstractBuilder mBuilder = null;
    public SpecDirector(AbstractBuilder builder) {
        mBuilder = builder;
    }
    public Spec construct(String s) {
        mBuilder.buildSname(s);
        mBuilder.buildextends(s);
        mBuilder.buildUsesType(s);
        mBuilder.buildSignature(s);
        mBuilder.buildAxioms(s);
        return mBuilder.getSort();
    }

    public static void main(String[] args) throws IOException{
        String s = "Spec Array;\n" +
                "uses Integer,Bool;\n" +
                "Const nil;\n" +
                "Attr \n" +
                "\tisEmpty: Bool;\n" +
                "\tlength: Integer;\n" +
                "Retr\n" +
                "\tgetMin(Array):Integer;\t\t\t\t\t// 数组的最小值\n" +
                "\tgetMax(Array):Integer;\t\t\t\t\t// 数组的最大值\n" +
                "\tgetElement(Integer):Integer;\t\t\t// 某索引位置的元素\n" +
                "\tgetIndex(Integer):Integer;\t\t\t\t// 返回某元素的索引位置\n" +
                "\tsum(Array):Integer;\t\t\t\t\t\t// 数组求和\n" +
                "Tran\n" +
                "\tinsert(Array,Integer,Integer):Array;\t// 往数组插入新元素\n" +
                "\tclear(Array):Array;\t\t\t\t\t\t// 清空数组\n" +
                "\tdel(Integer):Array;\t\t\t\t\t\t// 删除某索引位置的元素\n" +
                "\tisort(Array):Array;\t\t\t\t\t\t// 递增排序数组\n" +
                "\tdsort(Array):Array;\t\t\t\t\t\t// 递减排序数组\n" +
                "\treverse(Array):Array;\t\t\t\t\t// 数组逆序\n" +
                "Axiom\n" +
                "\n" +
                "\t\n" +
                "\t// 等价关系,元素调换顺序，不改变元素的值\n" +
                "\tFor all a:Array that\t\n" +
                "\t\ta.reverse() ≡ a;\t\n" +
                "\t\ta.reverse() ≡ a.dsort();\n" +
                "\t\ta.reverse() ≡ a.isort();\n" +
                "\t\t\n" +
                "\t\ta.dsort() ≡ a;\n" +
                "\t\ta.dsort() ≡ a.isort();\n" +
                "\t\t\n" +
                "\t\ta.isort() ≡ a;\t\t\n" +
                "\tEnd\n" +
                "End";
//        String specDoc = FileUtil.read("D:\\1NJUST\\大论文\\paper\\casestudy\\BasicSpec.txt");
//        String[] specs = specDoc.split("Spec");
//        SpecPackage specPackage = new SpecPackage();
//        List<Spec> list = new ArrayList<>();
//        int count = 0;
//        System.out.println(specs.length);
//        for (int i = 1;i<specs.length;i++){
//            specs[i] = "Spec" +  specs[i];
//            AbstractBuilder mBuilder = new SpecBuilder();
//            SpecDirector specDirector = new SpecDirector(mBuilder);
//            Spec spec = specDirector.construct(specs[i]);
//            list.add(count, spec);
//            count++;
//        }
//        specPackage.setSpecs(list);
//        System.out.println(list.get(0));
//        System.out.println(specPackage.getSpecs().get(0).getSpecName());


//        AbstractBuilder mBuilder = new SpecBuilder();
//        SpecDirector specDirector = new SpecDirector(mBuilder);
//        Spec spec = specDirector.construct(s);

//        System.out.println("specName:"+spec.getSpecName());
//        System.out.println("Uses:"+spec.getUsesType());
//        System.out.println("extends:"+spec.getExtendsSort());
//        System.out.println("Attributes:"+spec.getSignature().getAttributes());
//        System.out.println("Constants:"+spec.getSignature().getConstants());
//        System.out.println("Retrieves:"+spec.getSignature().getRetrieves());
//        System.out.println("Transforms:"+spec.getSignature().getTransforms());
//
//        for (Equation equation:spec.getAxioms().getEquations()) {
//            System.out.println("equation"+equation.toString());
//        }
    }
}
