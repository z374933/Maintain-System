package com.zhang.servce.impl;

import com.zhang.entily.Billboard;
import com.zhang.mapper.BillboardMapper;
import com.zhang.servce.BillboardService;
import com.zhang.tool.CreatNum;
import com.zhang.tool.Upload;
import com.zhang.vo.DataJson;
import com.zhang.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class BillboardServiceImpl implements BillboardService {
    @Autowired
    BillboardMapper billboardMapper;

    @Override
    public DataVO<Billboard> findData() {
        DataVO<Billboard> dataVO = new DataVO<>();
        dataVO.setCode(0);
        dataVO.setMsg("成功");
        dataVO.setData(billboardMapper.selectList(null));
        return dataVO;
    }

    @Override
    public DataJson uploadImg2(MultipartFile file, String id) {
        DataJson dataJson = new DataJson();
        Upload upload = new Upload();
        HashMap<String, String> map = new HashMap<>();
        upload.uploadImg(file, id);
        //输出日志
        map.put("url", "../images/" + id + ".img");
        dataJson.setCode(0);
        dataJson.setMsg("上传成功！");
        dataJson.setData(map);
        return dataJson;
    }

    @Override
    public int addBillboard(Billboard billboard) {
        CreatNum creatNum = new CreatNum();
        String id = creatNum.getId(6);
        billboard.setId(id);
        return billboardMapper.insert(billboard);
    }

    @Override
    public int deleteBillboards(ArrayList<String> ids) {
        int state = billboardMapper.deleteBatchIds(ids);
        return state;
    }

    @Override
    public int deleteBillboard(String id) {
        int state = billboardMapper.deleteById(id);
        return 0;
    }

    @Override
    public int updateBillboard(Billboard billboard) {
        int sate = billboardMapper.updateById(billboard);
        return 0;
    }

    @Override
    public DataVO<Billboard> whereFind(Billboard billboard) {
        HashMap<String, Object> map = new HashMap<>();
        if (billboard.getTitle() != null) {
            map.put("id", billboard.getId());
        }
        if (billboard.getContent() != null) {
            map.put("name", billboard.getContent());
        }
        List<Billboard> billboards = billboardMapper.selectByMap(map);
        DataVO<Billboard> dataVO = new DataVO<>();
        dataVO.setCode(0);
        dataVO.setMsg("成功");
        //通过查询数据库的求总数
        dataVO.setCount((long) billboards.size());
        dataVO.setData(billboards);
        return dataVO;
    }

    @Override
    public DataJson uploadImg(MultipartFile file, String id) {
        DataJson dataJson = new DataJson();
        Upload upload = new Upload();
        Billboard billboard = new Billboard();
        HashMap<String, String> map = new HashMap<>();
        //生成uuid
        UUID uuid = UUID.randomUUID();
        String imgName = uuid.toString().substring(0, 13);
        upload.uploadImg(file, imgName);
        //文件写入数据库
        billboard.setId(id);
        billboard.setImg(imgName + ".jpg");
        billboardMapper.updateById(billboard);
        //输出日志
        map.put("url", "../images/" + imgName + ".img");
        dataJson.setCode(0);
        dataJson.setMsg("上传成功！");
        dataJson.setData(map);
        return dataJson;
    }
}
