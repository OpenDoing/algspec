package com.doing.specification.controller;

import com.doing.specification.entity.SpecAndUsername;
import com.doing.specification.entity.Specification;
import com.doing.specification.mapper.SpecAndURepo;
import com.doing.specification.mapper.SpecRepo;
import com.doing.specification.service.SaveSpec;
import com.doing.specification.util.JacksonUtil;
import com.doing.specification.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class SpecController {

    @Value("${filepath}")
    private String filePath;

    @Autowired
    private SpecRepo specRepo;

    @Autowired
    private SpecAndURepo specAndURepo;

    @Autowired
    private SaveSpec saveSpec;

    @PostMapping("/save")
    public Object saveSpec(@RequestBody String body){
        //1、往spec表新增数据
        //TODO: 如果有就不用新增
        String username = JacksonUtil.parseString(body,"username" );
        String SpecID = JacksonUtil.parseString(body,"SpecID" );
        if (specAndURepo.findAllByUsernameAndSpecid(username, SpecID) == null) {
            SpecAndUsername specAndUsername = new SpecAndUsername();
            specAndUsername.setSpecid(SpecID);
            specAndUsername.setUsername(username);
            saveSpec.insert(SpecID, username);
        }
        //2、往specification新增数据
        String SubSpec = JacksonUtil.parseString(body, "specdoc");
        String userPath = filePath + username;
        String servicePath = userPath + "/" + SpecID;
        String finalPath = servicePath + "/" + SubSpec;
        File user = new File(userPath);
        if (!user.exists()){
            user.mkdirs();
        }
        File ser = new File(servicePath);
        if (!ser.exists()){
            ser.mkdirs();
        }
        Specification specification = new Specification();
        specification.setSpecid(SpecID);
        specification.setSubSpec(SubSpec);
        specification.setUsername(username);
        specification.setPath(finalPath);
        specRepo.save(specification);
        //3、字符串写入文件
        String content = JacksonUtil.parseString(body, "content");
        try {
            File file = new File(finalPath);
            PrintStream ps = new PrintStream(new FileOutputStream(file));
            ps.println(content);// 往文件里写入字符串
//			ps.append("666");// 在已有的基础上添加字符串
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ResponseUtil.ok(specification);
    }

    @PostMapping(value = "/spec")
    public Object spec(@RequestParam(value = "file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseUtil.fail(404, "文件为空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        File dest = new File(filePath + "/spec/" + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseUtil.fail(-1,"失败");
        }
        String str = "";
        try{
            FileReader reader = new FileReader(dest);//定义一个fileReader对象，用来初始化BufferedReader
            BufferedReader bReader = new BufferedReader(reader);//new一个BufferedReader对象，将文件内容读取到缓存
            StringBuilder sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中
            String s;
            while ((s =bReader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
                sb.append(s + "\n");//将读取的字符串添加换行符后累加存放在缓存中
                System.out.println(s);
            }
            str = sb.toString();
            System.out.println(str);
            bReader.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return ResponseUtil.ok("上传成功",str);
    }

    @GetMapping("/service")
    public List<SpecAndUsername> getServiceList(@RequestParam String username) {
        return specAndURepo.findAllByUsername(username);
    }
    @GetMapping("/listspec")
    public List<Specification> listspec(@RequestParam String username, @RequestParam String service) {
        return specRepo.findAllByUsernameAndSpecid(username, service);
    }
    @GetMapping("/content")
    public Object getSpecContent(@RequestParam String username, @RequestParam String service, @RequestParam String doc) {
        Specification specification = specRepo.findByUsernameAndSpecidAndSubSpec(username, service, doc);
        String filepath = specification.getPath();
        File file = new File(filepath);
        String content = "";
        try{
            FileReader reader = new FileReader(file);
            BufferedReader bReader = new BufferedReader(reader);
            StringBuilder sb = new StringBuilder();
            String s;
            while ((s =bReader.readLine()) != null) {
                sb.append(s + "\n");
                System.out.println(s);
            }
            content = sb.toString();
            bReader.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        Map<String, String> map = new HashMap<>();
        map.put("content", content);
        map.put("path", specification.getPath());
        return ResponseUtil.ok("规约内容",map);
    }
}
