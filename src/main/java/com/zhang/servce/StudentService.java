package com.zhang.servce;

import com.zhang.entily.Billboard;
import com.zhang.entily.Student;
import com.zhang.vo.DataJson;
import com.zhang.vo.DataVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

public interface StudentService {
    public DataVO<Student> findData(Integer page,Integer limit);
    public int addStudent(Student student);
    //通过ID批量删除
    public int deleteStudents(ArrayList<String> id);
    //通过id删除
    public int deleteStudent(String id);
    //编辑
    public int updateStudent(Student student);
    //模糊查询
    public DataVO<Student> whereFind(Student student);
    //图片上传
    public DataJson uploadImg(MultipartFile file, String id);
    //通过id查找
    public Student getStudentBySession(String id);

}
