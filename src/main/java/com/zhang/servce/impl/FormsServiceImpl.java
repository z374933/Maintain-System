package com.zhang.servce.impl;

import com.zhang.entily.Forms;
import com.zhang.entily.MonthVO;
import com.zhang.mapper.FormsMapper;
import com.zhang.mapper.MonthMapper;
import com.zhang.servce.FormsService;
import com.zhang.tool.CreatNum;
import com.zhang.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class FormsServiceImpl implements FormsService {

    @Autowired
    FormsMapper formsMapper;

    @Autowired
    MonthMapper monthMapper;

    @Override
    public DataVO<Forms> findData() {
        DataVO<Forms> dataVo = new DataVO<>();
        dataVo.setCode(0);
        dataVo.setMsg("ok");
        List<Forms> list = formsMapper.listForms();
        dataVo.setCount((long) list.size());
        dataVo.setData(list);
        return dataVo;
    }

    @Override
    public DataVO<Forms> findData2() {
        DataVO<Forms> dataVo = new DataVO<>();
        dataVo.setCode(0);
        dataVo.setMsg("ok");
        List<Forms> list = formsMapper.listForms2();
        dataVo.setCount((long) list.size());
        dataVo.setData(list);
        return dataVo;
    }

    @Override
    public int addForms(Forms forms) {
        CreatNum creatNum = new CreatNum();
        String id = creatNum.getId(13);
        forms.setId(id);
        int status = formsMapper.insert(forms);
        return status;
    }

    @Override
    public int deleteForms(String id) {
        formsMapper.deleteById(id);
        return 0;
    }

    @Override
    public int updateForms(Forms forms) {
        formsMapper.updateById(forms);
        return 0;
    }

    @Override
    public DataVO<Forms> whereFind(Forms forms) {
        HashMap<String, Object> map = new HashMap<>();
        if (forms.getStudent() != null) {
            map.put("student", forms.getStudent());
        }
        if (forms.getWorker() != null) {
            map.put("worker", forms.getWorker());
        }
        if (forms.getRoom() != null) {
            map.put("room", forms.getRoom());
        }
        List<Forms> formss = formsMapper.selectByMap(map);
        DataVO<Forms> dataVO = new DataVO<>();
        dataVO.setCode(0);
        dataVO.setMsg("成功");
        //通过查询数据库的求总数
        dataVO.setCount((long) formss.size());
        dataVO.setData(formss);
        return dataVO;
    }

    @Override
    public List<MonthVO> studentMonth(String id) {
        return monthMapper.listMonth(id);
    }

    @Override
    public List<MonthVO> workerMonth(String id) {
        return monthMapper.listMonth2(id);
    }

    @Override
    public String workerGet(String id, String workerID) {
        Forms forms = new Forms();
        forms.setId(id);
        forms.setWorker(workerID);
        forms.setState("已接单");
        formsMapper.updateById(forms);
        return "接单成功";
    }

    @Override
    public String workerSet(String id, String workerID, String state) {
        Forms forms = new Forms();
        forms.setId(id);
        forms.setWorker(workerID);
        forms.setState(state);
        formsMapper.updateById(forms);
        return "设置成功";
    }

    @Override
    public DataVO<Forms> findData3(String id) {
        DataVO<Forms> dataVo = new DataVO<>();
        dataVo.setCode(0);
        dataVo.setMsg("ok");
        List<Forms> list = formsMapper.listForms3(id);
        dataVo.setCount((long) list.size());
        dataVo.setData(list);
        return dataVo;
    }
    @Override
    public DataVO<Forms> findData4(String id) {
        DataVO<Forms> dataVo = new DataVO<>();
        dataVo.setCode(0);
        dataVo.setMsg("ok");
        List<Forms> list = formsMapper.listForms4(id);
        dataVo.setCount((long) list.size());
        dataVo.setData(list);
        return dataVo;
    }

    //用户查询订单
    public DataVO<Forms> findData5(String id,String value) {
        DataVO<Forms> dataVo = new DataVO<>();
        dataVo.setCode(0);
        dataVo.setMsg("ok");
        List<Forms> list = formsMapper.listForms5(id,value);
        dataVo.setCount((long) list.size());
        dataVo.setData(list);
        return dataVo;
    }
}
