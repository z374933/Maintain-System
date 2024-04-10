package com.zhang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhang.entily.Weekday;
import com.zhang.vo.CountWT;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WeekdayMapper extends BaseMapper<Weekday> {
    @Select("SELECT DAYNAME(create_date) AS weekday, COUNT(*) AS sum  \n" +
            "FROM forms  \n" +
            "WHERE create_date >= CURDATE() - INTERVAL WEEKDAY(CURDATE()) DAY AND  \n" +
            "      create_date <= CURDATE() + INTERVAL 6 DAY - INTERVAL WEEKDAY(CURDATE()) DAY  \n" +
            "GROUP BY weekday;")
    @Results({
            @Result(column = "weekday", property = "weekday"),
            @Result(column = "sum", property = "sum"),
    })
    List<Weekday> listWeekdayForms();

    @Select("SELECT 'student' AS name, COUNT(*) AS count FROM student  \n" +
            "UNION ALL  \n" +
            "SELECT 'worker' AS name, COUNT(*) AS count FROM worker;")
    @Results({
            @Result(column = "name", property = "name"),
            @Result(column = "count", property = "value"),
    })
    List<CountWT> listCountWT();
}
