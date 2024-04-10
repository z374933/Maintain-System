package com.zhang.servce.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhang.entily.Classify;
import com.zhang.mapper.ClassifyMapper;
import com.zhang.servce.ClassifyService;
import com.zhang.tool.CreatNum;
import com.zhang.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClassifyServiceImpl implements ClassifyService {
    @Autowired
    ClassifyMapper classifyMapper;

    @Override
    public DataVO<Classify> findData(Integer page, Integer limit) {
        DataVO<Classify> dataVO = new DataVO<>();
        dataVO.setCode(0);
        dataVO.setMsg("成功");
        //分页
        IPage<Classify> classifyPage = new Page<>(page, limit);
        IPage<Classify> result = classifyMapper.selectPage(classifyPage, null);
        //通过查询数据库的求总数
        dataVO.setCount(result.getTotal());
        dataVO.setData(result.getRecords());
        return dataVO;
    }

    @Override
    public int addClassify(Classify classify) {
        CreatNum creatNum = new CreatNum();
        String id = creatNum.getId(6);
        classify.setId(id);
        int status = classifyMapper.insert(classify);
        return status;
    }


    @Override
    public int deleteClassify(String id) {
        int state = classifyMapper.deleteById(id);
        return 0;
    }

    @Override
    public int updateClassify(Classify classify) {
        int sate = classifyMapper.updateById(classify);
        return 0;
    }
}
