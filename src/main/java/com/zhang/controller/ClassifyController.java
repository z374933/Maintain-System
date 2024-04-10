package com.zhang.controller;
import com.zhang.entily.Classify;
import com.zhang.servce.ClassifyService;
import com.zhang.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/classify")
public class ClassifyController {
    @Autowired
    ClassifyService classifyService;

    @RequestMapping("/list")
    public DataVO list(Integer page, Integer limit) {
        return classifyService.findData(page, limit);
    }

    @RequestMapping("/add")
    public String add(Classify classify) {
        int flag = classifyService.addClassify(classify);
        String msg = flag == 0 ? "操作失败！" : "操作成！";
        return msg;
    }

    @RequestMapping("/delete")
    public String delete(String id) {
        int flag = classifyService.deleteClassify(id);
        String msg = flag == 0 ? "删除失败！" : "删除成功！";
        return msg;
    }

    @RequestMapping("/update")
    public String update(Classify classify) {
        classifyService.updateClassify(classify);
        return "更新成功!";
    }

}
