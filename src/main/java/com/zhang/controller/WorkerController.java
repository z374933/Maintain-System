package com.zhang.controller;

import com.zhang.entily.Worker;
import com.zhang.servce.WorkerService;
import com.zhang.vo.DataJson;
import com.zhang.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping("/worker")
public class WorkerController {

    @Autowired
    WorkerService workerService;

    @RequestMapping("/list")
    public DataVO list(Integer page, Integer limit) {
        return workerService.findData(page, limit);
    }

    @RequestMapping("/add")
    public String add(Worker worker) {
        int flag = workerService.addWorker(worker);
        String msg = flag == 0 ? "操作失败！" : "操作成！";
        return msg;
    }

    @RequestMapping("/delete")
    public String delete(String id) {
        int flag = workerService.deleteWorker(id);
        String msg = flag == 0 ? "删除失败！" : "删除成功！";
        return msg;
    }

    @PostMapping("/deletes")
    public String deletes(String[] ids) {
        for (String id : ids) {
            workerService.deleteWorker(id);
        }
        return "ok";
    }

    @RequestMapping("/update")
    public String update(Worker worker) {
        workerService.updateWorker(worker);
        return "更新成功!";
    }

    @RequestMapping("/whereFind")
    public DataVO<Worker> whereFind(Worker worker) {
        if (worker.getId().equals("")) {
            worker.setId(null);
        }
        if (worker.getName().equals("")) {
            worker.setName(null);
        }
        if (worker.getGender().equals("")) {
            worker.setGender(null);
        }
        if (worker.getPhone().equals("")) {
            worker.setPhone(null);
        }
        return workerService.whereFind(worker);
    }

    @PostMapping("/img")
    public DataJson uploadImg(@RequestParam("file") MultipartFile file, String id) {
        return workerService.uploadImg(file, id);
    }
}
