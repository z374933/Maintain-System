package com.zhang.servce.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhang.entily.Student;
import com.zhang.entily.User;
import com.zhang.mapper.StudentMapper;
import com.zhang.mapper.UserMapper;
import com.zhang.servce.UserService;
import com.zhang.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    StudentMapper studentMapper;

    @Override
    public DataVO<User> findData(Integer page, Integer limit) {
        DataVO<User> dataVO = new DataVO<>();
        dataVO.setCode(0);
        dataVO.setMsg("成功");
        //分页
        IPage<User> userIPage = new Page<>(page, limit);
        IPage<User> result = userMapper.selectPage(userIPage, null);
        //通过查询数据库的求总数
        dataVO.setCount(result.getTotal());
        dataVO.setData(result.getRecords());
        return dataVO;
    }

    @Override
    public Integer selectUser(String id, String password) {
        User user = userMapper.selectById(id);
        if (user == null) {
            return 10;
        }//用户不存在
        if (!user.getPassword().equals(password)) {
            return 11;
        }//密码错误
        return user.getIdentity();
    }

    @Override
    public String addUser(String id, String password, Integer identity) {
        if (userMapper.selectById(id) != null) {
            return "用户已存在！";
        }
        User user = new User();
        user.setId(id);
        user.setPassword(password);
        user.setIdentity(identity);
        Student student = new Student();
        student.setId(id);
        userMapper.insert(user);
        studentMapper.insert(student);
        return "用户创建成功！";
    }

    @Override
    public Integer getIdentity(String id) {
        return userMapper.selectById(id).getIdentity();
    }

    @Override
    public String update(String id, String password) {
        User user = userMapper.selectById(id);
        user.setPassword(password);
        userMapper.updateById(user);
        return "更新成功！";
    }
}
