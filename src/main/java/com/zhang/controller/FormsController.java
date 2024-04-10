package com.zhang.controller;

import com.zhang.entily.Forms;
import com.zhang.entily.MonthVO;
import com.zhang.entily.Student;
import com.zhang.servce.FormsService;
import com.zhang.servce.StudentService;
import com.zhang.vo.DataVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/forms")
public class FormsController {
    @Autowired
    FormsService formsService;

    @Autowired
    HttpSession session;
    @Autowired
    StudentService studentService;

    @RequestMapping("list")
    public DataVO<Forms> list() {
        return formsService.findData();
    }

    @RequestMapping("list2")
    public DataVO<Forms> list2() {
        return formsService.findData2();
    }

    @RequestMapping("list3")
    public DataVO<Forms> list3() {
        String id = (String) session.getAttribute("id");
        return formsService.findData3(id);
    }
    //用户订单列表
    @RequestMapping("list4")
    public DataVO<Forms> list4() {
        String id = (String) session.getAttribute("id");
        return formsService.findData4(id);
    }
    //用户查询订单
    @RequestMapping("list5")
    public DataVO<Forms> list5(String content) {
        String id = (String) session.getAttribute("id");
        String value = '%' + content + '%';
        return formsService.findData5(id,value);
    }

    @RequestMapping("/add")
    public String add(Forms forms) {
        int flag = formsService.addForms(forms);
        String msg = flag == 0 ? "操作失败！" : "操作成！";
        return msg;
    }

    @RequestMapping("/delete")
    public String delete(String id) {
        int flag = formsService.deleteForms(id);
        String msg = flag == 0 ? "删除失败！" : "删除成功！";
        return msg;
    }


    @RequestMapping("/update")
    public String update(Forms forms) {
        formsService.updateForms(forms);
        return "更新成功!";
    }

    @RequestMapping("/whereFind")
    public DataVO<Forms> whereFind(Forms forms) {
        if (forms.getStudent().equals("")) {
            forms.setStudent(null);
        }
        if (forms.getWorker().equals("")) {
            forms.setWorker(null);
        }
        if (forms.getRoom().equals("")) {
            forms.setRoom(null);
        }
        return formsService.whereFind(forms);
    }

    @RequestMapping("/studentAdd")
    public String studentAdd(Forms forms) {
        String studentID = (String) session.getAttribute("id");
        Student student = studentService.getStudentBySession(studentID);
        forms.setStudent(studentID);
        forms.setRoom(student.getRoom());
        forms.setState("待接单");
        int flag = formsService.addForms(forms);
        String msg = flag == 0 ? "操作失败！" : "操作成！";
        return msg;
    }

    @RequestMapping("studentList")
    public DataVO<Forms> studentList() {
        Forms forms = new Forms();
        forms.setStudent((String) session.getAttribute("id"));
        return formsService.whereFind(forms);
    }

    @RequestMapping("studentMonth")
    public List<MonthVO> studentMonth() {
        return formsService.studentMonth((String) session.getAttribute("id"));
    }

    @RequestMapping("workerMonth")
    public List<MonthVO> workerMonth() {
        return formsService.workerMonth((String) session.getAttribute("id"));
    }

    //接单
    @RequestMapping("workerGet")
    public String workerGet(String id) {
        String workerID = (String) session.getAttribute("id");
        return formsService.workerGet(id, workerID);
    }

    //设置状态
    @RequestMapping("workerSet")
    public String workerSet(String id, String state) {
        String workerID = (String) session.getAttribute("id");
        return formsService.workerSet(id, workerID, state);
    }

    //设置状态(用户)
    @RequestMapping("workerSet2")
    public String workerSet2(String id) {
        return formsService.workerSet(id, null, "已完成");
    }

}
