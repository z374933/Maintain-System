package com.zhang.servce.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhang.entily.Student;
import com.zhang.mapper.StudentMapper;
import com.zhang.servce.StudentService;
import com.zhang.servce.UserService;
import com.zhang.tool.CreatNum;
import com.zhang.tool.Upload;
import com.zhang.vo.DataJson;
import com.zhang.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    UserService userService;

    @Override
    public DataVO<Student> findData(Integer page, Integer limit) {
        DataVO<Student> dataVO = new DataVO<>();
        dataVO.setCode(0);
        dataVO.setMsg("成功");
        //分页
        IPage<Student> studentIPage = new Page<>(page, limit);
        IPage<Student> result = studentMapper.selectPage(studentIPage, null);
        //通过查询数据库的求总数
        dataVO.setCount(result.getTotal());
        dataVO.setData(result.getRecords());
        return dataVO;
    }

    @Override
    public int addStudent(Student student) {
        CreatNum creatNum = new CreatNum();
        String id = creatNum.getId(6);
        student.setId(id);
        int status = studentMapper.insert(student);
        userService.addUser(student.getId(), "123456", 1);
        return status;
    }

    @Override
    public int deleteStudents(ArrayList<String> ids) {
        int state = studentMapper.deleteBatchIds(ids);
        return state;
    }

    @Override
    public int deleteStudent(String id) {
        int state = studentMapper.deleteById(id);
        return 0;
    }

    @Override
    public int updateStudent(Student student) {
        int sate = studentMapper.updateById(student);
        return 0;
    }

    @Override
    public DataVO<Student> whereFind(Student student) {
        HashMap<String, Object> map = new HashMap<>();
        if (student.getId() != null) {
            map.put("id", student.getId());
        }
        if (student.getName() != null) {
            map.put("name", student.getName());
        }
        if (student.getGender() != null) {
            map.put("gender", student.getGender());
        }
        if (student.getStudentClass() != null) {
            map.put("student_class", student.getStudentClass());
        }
        List<Student> students = studentMapper.selectByMap(map);
        DataVO<Student> dataVO = new DataVO<>();
        dataVO.setCode(0);
        dataVO.setMsg("成功");
        //通过查询数据库的求总数
        dataVO.setCount((long) students.size());
        dataVO.setData(students);
        return dataVO;
    }

    @Override
    public DataJson uploadImg(MultipartFile file, String id) {
        DataJson dataJson = new DataJson();
        Upload upload = new Upload();
        Student student = new Student();
        HashMap<String, String> map = new HashMap<>();
        //生成uuid
        UUID uuid = UUID.randomUUID();
        String imgName = uuid.toString().substring(0, 13);
        upload.uploadImg(file, imgName);
        //文件写入数据库
        student.setId(id);
        student.setImg(imgName + ".jpg");
        studentMapper.updateById(student);
        //输出日志
        map.put("url", "../images/" + imgName + ".img");
        dataJson.setCode(0);
        dataJson.setMsg("上传成功！");
        dataJson.setData(map);
        return dataJson;
    }

    @Override
    public Student getStudentBySession(String id) {
        return studentMapper.selectById(id);
    }


}
