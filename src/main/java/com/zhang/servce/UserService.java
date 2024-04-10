package com.zhang.servce;

import com.zhang.entily.User;
import com.zhang.vo.DataVO;

public interface UserService {
    public DataVO<User> findData(Integer page, Integer limit);

    public Integer selectUser(String id, String password);

    public String addUser(String id, String password, Integer identity);

    public Integer getIdentity(String id);

    public String update(String id, String password);
}