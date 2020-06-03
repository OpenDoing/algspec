package com.doing.array.controller;

import com.alibaba.fastjson.JSONObject;
import com.doing.array.dao.ArrayRepo;
import com.doing.array.entity.Array;
import com.doing.array.service.ArrayService;
import com.doing.array.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static java.lang.Thread.sleep;

/**
 * comment here
 *
 * @author Duyining
 * @date 2019/12/5
 */
@Slf4j
@Api(value = "ArrayController", description = "Array服务接口")
@RestController
public class ArrayController {

    @Autowired
    private ArrayRepo arrayRepo;
    @Autowired
    private ArrayService arrayService;

    @GetMapping("/array/min")
    @ApiOperation(value = "查询数组的最小值",notes = "根据数组的id来获取")
    public Object getMin(@RequestParam Integer id) {
        return ResponseUtil.ok(arrayService.getMin(id));
    }

    @GetMapping("/array/max")
    @ApiOperation(value = "查询数组的最大值",notes = "根据数组的id来获取")
    public Object getMax(@RequestParam Integer id) {
        return ResponseUtil.ok(arrayService.getMax(id));

    }

    @GetMapping("/array")
    @ApiOperation(value = "查询数组的所有元素",notes = "根据数组的id来获取")
    public Object getArray(@RequestParam Integer id) {
        log.info("收到新请求 id为：{}",id);
        return ResponseUtil.ok(arrayService.getArray(id));
    }

    @GetMapping("/array/ele")
    @ApiOperation(value = "查询某索引位置的元素",notes = "根据数组的id和索引index来获取")
    public Object getElement(@RequestParam Integer id,@RequestParam Integer index){
        return ResponseUtil.ok(arrayService.getElement(id,index ));
    }

    @GetMapping("/array/index")
    @ApiOperation(value = "返回某元素的索引位置",notes = "根据数组的id和元素ele来获取")
    public Object getIndex(@RequestParam Integer id,@RequestParam Integer ele){
        return ResponseUtil.ok(arrayService.getIndex(id,ele ));
    }

    @GetMapping("/array/sum")
    @ApiOperation(value = "求数组的和",notes = "根据数组的id来获取")
    public Object sum(@RequestParam Integer id){
        return ResponseUtil.ok(arrayService.sum(id));
    }

    @PostMapping("/array/insert")
    @ApiOperation(value = "在数组的索引index位置插入元素ele",notes = "根据数组的id、索引index、元素ele来插入")
    public Object insert(@RequestParam Integer id,@RequestParam Integer ele,@RequestParam Integer index){
        arrayService.insert(id,ele,index);
        return ResponseUtil.ok();
    }

    @PostMapping("/array/insert2")
    @ApiOperation(value = "在数组的索引index位置插入元素ele",notes = "根据数组的id、索引index、元素ele来插入")
    public Object insert2(@RequestBody String req) throws InterruptedException {
        JSONObject jsonObject = JSONObject.parseObject(req);
        int id = jsonObject.getInteger("id");
        int index = jsonObject.getInteger("index");
        int ele = jsonObject.getInteger("ele");
        log.info("请求参数： id：{} index： {} ele：{}",id ,index,ele );
        arrayService.insert(id,ele,index);
        return ResponseUtil.ok();
    }

    @PostMapping("/array/clear")
    @ApiOperation(httpMethod = "POST",value = "清空数组的元素",notes = "根据数组的id来清除")
    public Object clear(@RequestParam Integer id){
        arrayService.clear(id);
        return ResponseUtil.ok();
    }

    @PostMapping("/array/del")
    @ApiOperation(value = "删除数组索引index位置的元素",notes = "根据数组的id和索引index来删除")
    public Object del(@RequestParam Integer id,@RequestParam Integer index){
        arrayService.del(id,index);
        return ResponseUtil.ok();
    }

    @PostMapping("/array/del2")
    @ApiOperation(value = "删除数组索引index位置的元素",notes = "根据数组的id和索引index来删除")
    public Object del2(@RequestBody String req){
        JSONObject jsonObject = JSONObject.parseObject(req);
        int id = jsonObject.getInteger("id");
        int index = jsonObject.getInteger("index");
        arrayService.del(id,index);
        return ResponseUtil.ok();
    }

    @PostMapping("/array/isort")
    @ApiOperation(value = "数组升序",notes = "根据数组的id来排序")
    public Object isort(@RequestParam Integer id){
        arrayService.isort(id);
        return ResponseUtil.ok();
    }

    @PostMapping("/array/dsort")
    @ApiOperation(value = "数组降序",notes = "根据数组的id来排序")
    public Object dsort(@RequestParam Integer id){
        arrayService.dsort(id);
        return ResponseUtil.ok();
    }

    @PostMapping("/array/reverse")
    @ApiOperation(value = "数组逆序",notes = "根据数组的id来排序")
    public Object reverse(@RequestParam Integer id){
        arrayService.reverse(id);
        return ResponseUtil.ok();
    }

    @GetMapping("/six")
    @ApiOperation(value = "测试",notes = "实体类测试")
    public Object getSomething(@RequestBody Array arr) {
        return ResponseUtil.ok();
    }

    @PutMapping("/array/modify")
    @ApiOperation(value = "修改数组元素",notes = "通过数组id查询，通过索引位置来修改目标元素")
    public Object getSomething(@RequestParam Integer id,@RequestParam Integer ele,@RequestParam Integer index) {
        arrayService.modifyEle(id, index, ele);
        return ResponseUtil.ok();
    }

    @DeleteMapping("/array/del")
    @ApiOperation(value = "删除整个数组",notes = "通过数组id进行删除")
    public Object deleteArray(@RequestParam Integer id){
        arrayService.deleArray(id);
        return ResponseUtil.ok();
    }
}
