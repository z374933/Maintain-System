package com.zhang.servce;

import com.zhang.entily.Billboard;
import com.zhang.vo.DataJson;
import com.zhang.vo.DataVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

public interface BillboardService {
    public DataVO<Billboard> findData();
    //上传轮播图
    public DataJson uploadImg2(MultipartFile file, String id);

    public int addBillboard(Billboard billboard);
    //通过ID批量删除
    public int deleteBillboards(ArrayList<String> id);
    //通过id删除
    public int deleteBillboard(String id);
    //编辑
    public int updateBillboard(Billboard billboard);
    //模糊查询
    public DataVO<Billboard> whereFind(Billboard billboard);
    //图片上传
    public DataJson uploadImg(MultipartFile file, String id);
}
