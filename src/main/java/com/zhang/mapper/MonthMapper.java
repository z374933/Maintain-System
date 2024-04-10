package com.zhang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhang.entily.MonthVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MonthMapper extends BaseMapper<MonthVO> {
    @Select("SELECT DATE_FORMAT(create_date, '%m') AS month, COUNT(*) AS num  FROM forms where student = #{id} GROUP BY month  ")
    @Results({
            @Result(column = "month", property = "month"),
            @Result(column = "num", property = "num"),
    })
    List<MonthVO> listMonth(@Param("id") String id);

    @Select("SELECT DATE_FORMAT(create_date, '%m') AS month, COUNT(*) AS num  FROM forms where worker = #{id} GROUP BY month  ")
    @Results({
            @Result(column = "month", property = "month"),
            @Result(column = "num", property = "num"),
    })
    List<MonthVO> listMonth2(@Param("id") String id);
}
