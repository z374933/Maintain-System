package com.zhang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhang.entily.Forms;
import com.zhang.entily.Student;
import com.zhang.entily.Worker;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FormsMapper extends BaseMapper<Forms> {
    @Select("select \n" +
            "f.id,f.room,f.classify,f.content,f.state,f.notes,f.create_date,f.update_date,\n" +
            "t.name as tname,w.name as wname ,c.name as cname from forms f \n" +
            "LEFT JOIN student t on f.student=t.id\n" +
            "LEFT JOIN classify c on f.classify=c.id\n" +
            "LEFT JOIN worker w on f.worker=w.id")

    @Results({
            @Result(column = "tname", property = "student"),
            @Result(column = "cname", property = "classify"),
            @Result(column = "wname", property = "worker"),
    })
    List<Forms> listForms();

    //Forms formatForms(@Param("formID") String id);
    @Select("select \n" +
            "f.id,f.room,f.classify,f.content,f.state,f.notes,f.create_date,f.update_date,\n" +
            "t.name as tname,w.name as wname ,c.name as cname from forms f \n" +
            "LEFT JOIN student t on f.student=t.id\n" +
            "LEFT JOIN classify c on f.classify=c.id\n" +
            "LEFT JOIN worker w on f.worker=w.id where f.state='待接单'")

    @Results({
            @Result(column = "tname", property = "student"),
            @Result(column = "cname", property = "classify"),
            @Result(column = "wname", property = "worker"),
    })
    List<Forms> listForms2();

    @Select("select \n" +
            "f.id,f.room,f.classify,f.content,f.state,f.notes,f.create_date,f.update_date,\n" +
            "t.name as tname,w.name as wname ,c.name as cname from forms f \n" +
            "LEFT JOIN student t on f.student=t.id\n" +
            "LEFT JOIN classify c on f.classify=c.id\n" +
            "LEFT JOIN worker w on f.worker=w.id where f.worker=#{id};")

    @Results({
            @Result(column = "tname", property = "student"),
            @Result(column = "cname", property = "classify"),
            @Result(column = "wname", property = "worker"),
    })
    List<Forms> listForms3(@Param("id") String id);

    @Select("select \n" +
            "f.id,f.room,f.classify,f.content,f.state,f.notes,f.create_date,f.update_date,\n" +
            "t.name as tname,c.name as cname from forms f \n" +
            "LEFT JOIN student t on f.student=t.id\n" +
            "LEFT JOIN classify c on f.classify=c.id\n" +
            "where f.student=#{id};")

    @Results({
            @Result(column = "tname", property = "student"),
            @Result(column = "cname", property = "classify"),
    })
    List<Forms> listForms4(@Param("id") String id);

    @Select("select \n" +
            "f.id,f.room,f.classify,f.content,f.state,f.notes,f.create_date,f.update_date,\n" +
            "t.name as tname,c.name as cname from forms f \n" +
            "LEFT JOIN student t on f.student=t.id\n" +
            "LEFT JOIN classify c on f.classify=c.id\n" +
            "where f.student=#{id} and f.content LIKE #{value};")

    @Results({
            @Result(column = "tname", property = "student"),
            @Result(column = "cname", property = "classify"),
    })
    List<Forms> listForms5(@Param("id") String id,@Param("value") String value);
}
