package com.zhang.controller;

import com.zhang.servce.UserService;
import com.zhang.tool.Constant;
import com.zhang.vo.DataVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    HttpServletResponse response;
    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpSession session;

    @RequestMapping("/list")
    public DataVO list(Integer page, Integer limit) {
        return userService.findData(page, limit);
    }

    @RequestMapping("/addUser")
    public String addUser(String id, String password) {
        return userService.addUser(id, password, 1);
    }

    @RequestMapping("/login")
    public String login(String id, String password) {
        Integer flag = userService.selectUser(id, password);
        if (flag == 10) {
            return "用户不存在";
        }
        if (flag == 11) {
            return "用户密码错误";
        }
        session.setAttribute("id", id);
        session.setAttribute("password", password);
        session.setAttribute("identity", flag);
        return "登录成功";
    }

    @RequestMapping("/init")
    public String init() {
        Integer flag = (Integer) session.getAttribute("identity");
        if (session.getAttribute("identity") != null) {
            if (flag == 0) {
                return Constant.MENU0;
            }
            if (flag == 1) {
                return Constant.MENU1;
            }
            if (flag == 2) {
                return Constant.MENU2;
            }
        }
        return Constant.MENU3;
    }

    @RequestMapping("/is")
    public Integer getIdentity() {
        return (Integer) session.getAttribute("identity");
    }

    @RequestMapping("/update")
    public String update(String id, String new_password) {
        return userService.update(id, new_password);
    }

    @RequestMapping("/exit")
    public String exit() {
        if (session != null) {
            session.invalidate();//清空session
        }
        return "用户已退出";
    }

}
