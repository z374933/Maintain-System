package com.zhang.controller;

import com.zhang.entily.Student;
import com.zhang.servce.StudentService;
import com.zhang.tool.CreatNum;
import com.zhang.tool.Upload;
import com.zhang.vo.DataJson;
import com.zhang.vo.DataVO;
import com.zhang.vo.StudentVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Array;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @Autowired
    HttpSession session;

    @RequestMapping("/list")
    public DataVO list(Integer page, Integer limit) {
        return studentService.findData(page, limit);
    }

    @RequestMapping("/add")
    public String add(Student student) {
        int flag = studentService.addStudent(student);
        String msg = flag == 0 ? "操作失败！" : "操作成！";
        return msg;
    }

    @RequestMapping("/delete")
    public String delete(String id) {
        int flag = studentService.deleteStudent(id);
        String msg = flag == 0 ? "删除失败！" : "删除成功！";
        return msg;
    }

    @PostMapping("/deletes")
    public String deletes(String[] ids) {
        for (String id:ids){
            studentService.deleteStudents(new ArrayList<>(List.of(ids)));
        }
        return "ok";
    }

    @RequestMapping("/update")
    public String update(Student student) {
        studentService.updateStudent(student);
        return "更新成功!";
    }

    @RequestMapping("/whereFind")
    public DataVO<Student> whereFind(Student student){
        if (student.getId().equals("")) {student.setId(null);}
        if (student.getName().equals("")) {student.setName(null);}
        if (student.getGender().equals("")) {student.setGender(null);}
        if (student.getStudentClass().equals("")) {student.setStudentClass(null);}
        return studentService.whereFind(student);
    }

    @PostMapping("/img")
    public DataJson uploadImg(@RequestParam("file") MultipartFile file, String id) {
        return studentService.uploadImg(file,id);
    }

    @PostMapping("/getOneStudent")
    public Student getStudentBySession(){
        String id = (String) session.getAttribute("id");
        return studentService.getStudentBySession(id);
    }
}
