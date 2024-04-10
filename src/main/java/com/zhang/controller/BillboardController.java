package com.zhang.controller;

import com.zhang.entily.Billboard;
import com.zhang.servce.BillboardService;
import com.zhang.vo.DataJson;
import com.zhang.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/billboard")
@CrossOrigin(origins = "*")
public class BillboardController {

    @Autowired
    BillboardService billboardService;

    @RequestMapping("/list")
    public DataVO list() {
        return billboardService.findData();
    }

    @PostMapping("/img2")
    public DataJson uploadImg2(@RequestParam("file") MultipartFile file, String id) {
        return billboardService.uploadImg2(file, id);
    }

    @RequestMapping("/add")
    public String add(Billboard billboard) {
        int flag = billboardService.addBillboard(billboard);
        String msg = flag == 0 ? "操作失败！" : "操作成！";
        return msg;
    }

    @RequestMapping("/delete")
    public String delete(String id) {
        int flag = billboardService.deleteBillboard(id);
        String msg = flag == 0 ? "删除失败！" : "删除成功！";
        return msg;
    }

    @PostMapping("/deletes")
    public String deletes(String[] ids) {
        for (String id : ids) {
            billboardService.deleteBillboards(new ArrayList<>(List.of(ids)));
        }
        return "ok";
    }

    @RequestMapping("/update")
    public String update(Billboard billboard) {
        billboardService.updateBillboard(billboard);
        return "更新成功!";
    }


    @PostMapping("/img")
    public DataJson uploadImg(@RequestParam("file") MultipartFile file, String id) {
        return billboardService.uploadImg(file, id);
    }
}
