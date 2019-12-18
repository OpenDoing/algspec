package controller;

import entity.Spec;
import entity.SpecPackage;
import entity.build.AbstractBuilder;
import entity.build.SpecBuilder;
import entity.build.SpecDirector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pub.imlichao.EntityTest;
import pub.imlichao.EntityTest1;

import java.util.ArrayList;
import java.util.Date;

/**
 * comment here
 *
 * @author Duyining
 * @date 2019/10/17
 */
@RestController
public class SpecController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/spec")
    public Object getSpec(@RequestParam String packageName) {
        System.out.println(666);
        Query query = new Query(Criteria.where("packageName").is(packageName));
        SpecPackage specPackage = mongoTemplate.findOne(query, SpecPackage.class);
        return specPackage;
    }

//    //新增文档
//    @GetMapping(value = "/insertspec")
//    public String insert(){
//        String s = "Spec ListofCase;\n" +
//                "\tuses Case,Integer;\n" +
//                "\tAttr\n" +
//                "\t\tcases[1..*]:Case;\n" +
//                "\t\tlength:Integer;\n" +
//                "\tAxiom\n" +
//                "\t\tFor all lc:ListOfCase, c1,c2:Case That\n" +
//                "\t\t\tlc.length >= 0;\n" +
//                "\t\t\tlc.cases = null, if lc.length = 0;\n" +
//                "\t\t\tlc.cases <> null , if lc.length > 0;\n" +
//                "\t\tEnd\n" +
//                "End\t";
//        AbstractBuilder mBuilder = new SpecBuilder();
//        SpecDirector specDirector = new SpecDirector(mBuilder);
//        Spec spec = specDirector.construct(s);
//        mongoTemplate.insert(spec);
//        return "redirect:/find";
//    }
}
