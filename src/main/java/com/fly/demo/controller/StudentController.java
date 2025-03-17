package com.fly.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fly.demo.model.Student;
import com.fly.demo.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentService studentService;

    @GetMapping( path = "/getList")
    public List<Student> getList(){
        List<Student> students = studentService.queryAll();
        JSONArray arry=new JSONArray();
        arry.addAll(students);
        logger.info("list student = "+arry.toString());
        return students;
    }

    @ResponseBody
    @GetMapping( path = "/findByPage")
    public JSONObject findByPage(HttpServletRequest request){
        Map<String, String> map=new HashMap<>();
        //String userName=new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
        //map.put("userName","李四");
        int pageNumber=1;
        int pageSize=2;
        List<Student> studentList = studentService.queryAll();
        pageSize=Integer.parseInt(request.getParameter("rows"));
        pageNumber=Integer.parseInt(request.getParameter("page"));
        PageHelper.startPage(pageNumber, pageSize);
        PageInfo<Student> pageInfo = new PageInfo(studentList);
        JSONObject json=new JSONObject();
        json.put("rows", pageInfo.getList());
        json.put("total", pageInfo.getTotal());
        return json;
    }

    @GetMapping( path = "/getStudent")
    public String getList(@Param("id") Integer id){
        Student students = studentService.getStudent(id);
        String str = new Gson().toJson(students);
        logger.info("query student by "+id +",result = "+str);
        return str;
    }

    @PostMapping(path = "/insert")
    public String insert(@RequestBody Student student){
        int insert = studentService.insert(student);
        String msg = "";
        if( insert > 0 ){
            msg = "{\"msg\":\"新增成功\",\"flag\":true}";
        }else {
            msg = "{\"msg\":\"新增失败\",\"flag\":false}";
        }
        return msg;
    }

    @GetMapping(path = "/delete")
    public String delete(@Param("numberCode") Integer id){
        int delete = studentService.delete(id);
        String msg = "";
        if( delete > 0 ){
            msg = "{\"msg\":\"删除成功！！\",\"flag\":true}";
        }else {
            msg = "{\"msg\":\"删除失败！！\",\"flag\":false}";
        }
        return msg;
    }

    @PostMapping(path = "/update")
    public String update(@RequestBody Student student){
        int update = studentService.update(student);
        String msg = "";
        if( update > 0 ){
            msg = "{\"msg\":\"更新成功！！！\",\"flag\":true}";
        }else {
            msg = "{\"msg\":\"更新失败！！！\",\"flag\":false}";
        }
        return msg;
    }

}
