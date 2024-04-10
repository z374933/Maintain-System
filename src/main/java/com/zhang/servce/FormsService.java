package com.zhang.servce;

import com.zhang.entily.Forms;
import com.zhang.entily.MonthVO;
import com.zhang.vo.DataVO;

import java.util.List;

public interface FormsService {
    public DataVO<Forms> findData();

    //接单查询
    public DataVO<Forms> findData2();

    //添加表单
    public int addForms(Forms forms);

    //通过id删除
    public int deleteForms(String id);

    //编辑
    public int updateForms(Forms forms);

    //模糊查询
    public DataVO<Forms> whereFind(Forms forms);

    //查询用户本月订单数量
    public List<MonthVO> studentMonth(String id);

    public List<MonthVO> workerMonth(String id);

    //工作人员获取订单
    public String workerGet(String id, String workerID);

    //工作人员处理订单
    public String workerSet(String id, String workerID, String state);

    //工作人员查询
    public DataVO<Forms> findData3(String id);

    //用户订单列表
    public DataVO<Forms> findData4(String id);

    //用户查询订单
    public DataVO<Forms> findData5(String id,String value);
}
