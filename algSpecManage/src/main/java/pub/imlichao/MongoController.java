package pub.imlichao;

import com.alibaba.fastjson.JSON;
import entity.Spec;
import entity.SpecPackage;
import entity.axiom.Equation;
import entity.build.AbstractBuilder;
import entity.build.SpecBuilder;
import entity.build.SpecDirector;
import entity.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.mongodb.client.model.Aggregates.unwind;

@RestController
public class MongoController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping(value = "/")
    public String index(){
        return "redirect:/find";
    }

    @GetMapping(value = "/spec")
    public Object getSpec(@RequestParam String packageName) {
        System.out.println(111);
        Query query = new Query(Criteria.where("packageName").is(packageName));
//        SpecPackage specPackage = mongoTemplate.findOne(query, SpecPackage.class);
//        Aggregation aggregation = new Aggregation(
//                unwind("$specs"),
//                match(Criteria.where("packageName").is(packageName).and("specName").is("Ptient")),
//
//        );
        SpecPackage specPackage = mongoTemplate.findOne(query, SpecPackage.class);
        for (Spec s:specPackage.getSpecs()) {
            if (s.getSpecName().equals("Doctor")){
                return s.getSignature().getAttributes().getAttrs().toString();
            }
        }
        return "nonono";
    }

    @GetMapping(value = "/attr")
    public String getAttr(@RequestParam String packageName,@RequestParam String specName) {
        Query query = new Query(Criteria.where("packageName").is(packageName));
        SpecPackage specPackage = mongoTemplate.findOne(query, SpecPackage.class);
        for (Spec s:specPackage.getSpecs()) {
            if (s.getSpecName().equals(specName)){
//                String attr = s.getSignature().getAttributes().getAttrs().toString();
//                // 此处的字符处理是和fastjson.JSON对接，JSON只能把：变为hashmap
//                return attr.replaceAll("=", ":");
                return JSON.toJSONString(s.getSignature().getAttributes().getAttrs());
            }
        }
        return "";
    }

    @GetMapping(value = "/axiom")
    public List<Equation> getAxiom(@RequestParam String packageName, @RequestParam String specName) {
        Query query = new Query(Criteria.where("packageName").is(packageName));
        SpecPackage specPackage = mongoTemplate.findOne(query, SpecPackage.class);
        for (Spec s:specPackage.getSpecs()) {
            if (s.getSpecName().equals(specName)){
                return s.getAxioms().getEquations();
            }
        }
        return null;
    }

    //新增文档
    @GetMapping(value = "/insert")
    public String insert(){
        //insert方法并不提供级联类的保存，所以级联类需要先自己先保存
        EntityTest1 entityTest1_1 = new EntityTest1(1000L);
        //执行完insert后对象entityTest1将会获得保存后的id
        mongoTemplate.insert(entityTest1_1);
        //再添加一条
        EntityTest1 entityTest1_2 = new EntityTest1(1001L);
        mongoTemplate.insert(entityTest1_2);
        //创建列表并将保存后的关联对象添加进去
        ArrayList<EntityTest1> entityTest1List = new ArrayList<EntityTest1>();
        entityTest1List.add(entityTest1_1);
        entityTest1List.add(entityTest1_2);

        //新增主体对象
        EntityTest entityTest = new EntityTest(100L,"test",new Date(),10,entityTest1List);
        //新增数据的主键已经存在，则会抛DuplicateKeyException异常
        mongoTemplate.insert(entityTest);
        return "redirect:/find";
    }

    //新增文档
    @GetMapping(value = "/insertspec")
    public String insertsp() throws IOException{
        String s = "Spec Array;\n" +
                "uses Integer,Bool;\n" +
                "Const nil;\n" +
                "Attr \n" +
                "\tisEmpty: Bool;\n" +
                "\tlength: Integer;\n" +
                "Retr\n" +
                "\tgetMin(Array):Integer;\n" +
                "\tgetMax(Array):Integer;\n" +
                "\tgetElement(Integer):Integer;\n" +
                "\tgetIndex(Integer):Integer;\n" +
                "\tsum(Array):Integer;\n" +
                "Tran\n" +
                "\tinsert(Array,Integer,Integer):Array;\n" +
                "\tclear(Array):Array;\n" +
                "Axiom\n" +
                "\n" +
                "\tFor all a:Array that\t\n" +
                "\t\ta.reverse() ≡ a , if a.length <> 0;\t\t\t\t\t\t\n" +
                "\t\ta.reverse() ≡ a.dsort();\n" +
                "\t\ta.reverse() ≡ a.isort();\n" +
                "\t\t\n" +
                "\t\ta.dsort() ≡ a;\n" +
                "\t\ta.dsort() ≡ a.isort();\n" +
                "\t\t\n" +
                "\t\ta.isort() ≡ a;\t\t\n" +
                "\tEnd\n" +
                "End";
//        AbstractBuilder mBuilder = new SpecBuilder();
//        SpecDirector specDirector = new SpecDirector(mBuilder);
//        Spec spec = specDirector.construct(s);
//        System.out.println(spec.getAxioms().getEquations());
//        mongoTemplate.insert(spec);


        String specDoc = FileUtil.read("D:\\1NJUST\\大论文\\paper\\casestudy\\req.txt");
        String[] specs = specDoc.split("Spec");
        SpecPackage specPackage = new SpecPackage();
        List<Spec> list = new ArrayList<>();
        int count = 0;
        System.out.println(specs.length);
        for (int i = 1;i<specs.length;i++){
            specs[i] = "Spec" +  specs[i];
            AbstractBuilder mBuilder = new SpecBuilder();
            SpecDirector specDirector = new SpecDirector(mBuilder);
            Spec spec = specDirector.construct(specs[i]);
            list.add(count, spec);
            count++;
        }
        System.out.println(list.get(0));
        specPackage.setSpecs(list);
        specPackage.setPackageName("com.Array.req");
        mongoTemplate.insert(specPackage);
        return "redirect:/find";
    }

    //保存文档
    //保存与新增的主要区别在于，如果主键已经存在，新增抛出异常，保存修改数据
    @GetMapping(value = "/save")
    public String save(){
        //查询最后一条数据并更新
        Sort sort = new Sort(Sort.Direction.DESC,"parameter3");
        EntityTest entityTest = mongoTemplate.findOne(Query.query(Criteria.where("")).with(sort),EntityTest.class);
        entityTest.setParameter4(3000);
        //保存数据的主键已经存在，则会对已经存在的数据修改
        mongoTemplate.save(entityTest);
        return "redirect:/find";
    }

    //删除文档
    @GetMapping(value = "/delete")
    public String delete(){
        //查询第一条数据并删除
        EntityTest entityTest = mongoTemplate.findOne(Query.query(Criteria.where("")),EntityTest.class);
        //remove方法不支持级联删除所以要单独删除子数据
        List<EntityTest1> entityTest1List = entityTest.getParameter5();
        for(EntityTest1 entityTest1:entityTest1List){
            mongoTemplate.remove(entityTest1);
        }
        //删除主数据
        mongoTemplate.remove(entityTest);

        return "redirect:/find";
    }

    //更新文档
    @GetMapping(value = "/update")
    public String update(){
        //将查询条件符合的全部文档更新
        Query query = new Query();
        Update update = Update.update("parameter2_","update");
        mongoTemplate.updateMulti(query,update,EntityTest.class);
        return "redirect:/find";
    }

    //查询文档
    @GetMapping(value = "/find")
    public String find(Model model){
        //查询小于当前时间的数据，并按时间倒序排列
        Sort sort = new Sort(Sort.Direction.DESC,"parameter3");
        List<EntityTest> findTestList = mongoTemplate.find(Query.query(Criteria.where("parameter3").lt(new Date())).with(sort) ,EntityTest.class);
        model.addAttribute("findTestList",findTestList);

        //使用findOne查询如果结果极为多条，则返回排序在最上面的一条
        EntityTest findOneTest = mongoTemplate.findOne(Query.query(Criteria.where("parameter3").lt(new Date())).with(sort) ,EntityTest.class);
        model.addAttribute("findOneTest",findOneTest);

        //模糊查询
        List<EntityTest> findTestList1 = mongoTemplate.find(Query.query(Criteria.where("parameter3").lt(new Date()).and("parameter2").regex("es")) ,EntityTest.class);
        model.addAttribute("findTestList1",findTestList1);

        //分页查询（每页3行第2页）
        Pageable pageable = new PageRequest(1,3,sort);
        List<EntityTest> findTestList2 = mongoTemplate.find(Query.query(Criteria.where("parameter3").lt(new Date())).with(pageable) ,EntityTest.class);
        //共多少条
        Long count = mongoTemplate.count(Query.query(Criteria.where("parameter3").lt(new Date())),EntityTest.class);
        //返回分页对象
        Page<EntityTest> page = new PageImpl<EntityTest>(findTestList2,pageable,count);
        model.addAttribute("page",page);

        //分页查询（通过起始行和数量也可以自己实现分页逻辑）
        List<EntityTest> findTestList3 = mongoTemplate.find(Query.query(Criteria.where("parameter3").lt(new Date())).with(sort).skip(3).limit(3) ,EntityTest.class);
        model.addAttribute("findTestList3",findTestList3);

        return "/index";
    }
}
