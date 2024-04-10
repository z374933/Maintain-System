package com.zhang.servce.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhang.entily.Worker;
import com.zhang.mapper.WorkerMapper;
import com.zhang.servce.UserService;
import com.zhang.servce.WorkerService;
import com.zhang.tool.CreatNum;
import com.zhang.tool.Upload;
import com.zhang.vo.DataJson;
import com.zhang.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    WorkerMapper workerMapper;
    @Autowired
    UserService userService;

    @Override
    public DataVO<Worker> findData(Integer page, Integer limit) {
        DataVO<Worker> dataVO = new DataVO<>();
        dataVO.setCode(0);
        dataVO.setMsg("成功");
        //分页
        IPage<Worker> workerIPage = new Page<>(page, limit);
        IPage<Worker> result = workerMapper.selectPage(workerIPage, null);
        //通过查询数据库的求总数
        dataVO.setCount(result.getTotal());
        dataVO.setData(result.getRecords());
        return dataVO;
    }

    @Override
    public int addWorker(Worker worker) {
        CreatNum creatNum = new CreatNum();
        String id = creatNum.getId(6);
        worker.setId(id);
        int status = workerMapper.insert(worker);
        userService.addUser(worker.getId(), "123456", 2);
        return status;
    }

    @Override
    public int deleteWorkers(ArrayList<String> ids) {
        int state = workerMapper.deleteBatchIds(ids);
        return state;
    }

    @Override
    public int deleteWorker(String id) {
        int state = workerMapper.deleteById(id);
        return 0;
    }

    @Override
    public int updateWorker(Worker worker) {
        int sate = workerMapper.updateById(worker);
        return 0;
    }

    @Override
    public DataVO<Worker> whereFind(Worker worker) {
        HashMap<String, Object> map = new HashMap<>();
        if (worker.getId() != null) {
            map.put("id", worker.getId());
        }
        if (worker.getName() != null) {
            map.put("name", worker.getName());
        }
        if (worker.getGender() != null) {
            map.put("gender", worker.getGender());
        }
        if (worker.getPhone() != null) {
            map.put("phone", worker.getPhone());
        }
        List<Worker> workers = workerMapper.selectByMap(map);
        DataVO<Worker> dataVO = new DataVO<>();
        dataVO.setCode(0);
        dataVO.setMsg("成功");
        //通过查询数据库的求总数
        dataVO.setCount((long) workers.size());
        dataVO.setData(workers);
        return dataVO;
    }

    @Override
    public DataJson uploadImg(MultipartFile file, String id) {
        DataJson dataJson = new DataJson();
        Upload upload = new Upload();
        Worker worker = new Worker();
        HashMap<String, String> map = new HashMap<>();
        //生成uuid
        UUID uuid = UUID.randomUUID();
        String imgName = uuid.toString().substring(0, 13);
        upload.uploadImg(file, imgName);
        //文件写入数据库
        worker.setId(id);
        worker.setImg(imgName + ".jpg");
        workerMapper.updateById(worker);
        //输出日志
        map.put("url", "../images/" + imgName + ".img");
        dataJson.setCode(0);
        dataJson.setMsg("上传成功！");
        dataJson.setData(map);
        return dataJson;
    }
}
