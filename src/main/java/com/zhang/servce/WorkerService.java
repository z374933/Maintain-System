package com.zhang.servce;

import com.zhang.entily.Worker;
import com.zhang.vo.DataJson;
import com.zhang.vo.DataVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

public interface WorkerService {
    //查询
    public DataVO<Worker> findData(Integer page, Integer limit);

    public int addWorker(Worker worker);

    //通过ID批量删除
    public int deleteWorkers(ArrayList<String> id);

    //通过id删除
    public int deleteWorker(String id);

    //编辑
    public int updateWorker(Worker worker);

    //模糊查询
    public DataVO<Worker> whereFind(Worker worker);

    //图片上传
    public DataJson uploadImg(MultipartFile file, String id);
}
