package com.zhang.servce;

import com.zhang.entily.Classify;
import com.zhang.vo.DataVO;

public interface ClassifyService {
    //查询
    public DataVO<Classify> findData(Integer page, Integer limit);

    //新增
    public int addClassify(Classify classify);

    //删除
    public int deleteClassify(String id);

    //编辑
    public int updateClassify(Classify classify);
}
