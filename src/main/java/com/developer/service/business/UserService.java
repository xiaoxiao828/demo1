package com.developer.service.business;

import com.developer.dao.model.UserInfo;

import java.util.List;

/**
 * Created by xiao.lai on 15/12/22.
 */
public interface UserService {
    UserInfo getUserById(int id);

    List<UserInfo> getUsers();

    int insert(UserInfo userInfo);
}
