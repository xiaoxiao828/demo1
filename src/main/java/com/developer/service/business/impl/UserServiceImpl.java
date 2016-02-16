package com.developer.service.business.impl;

import com.developer.dao.model.UserInfo;
import com.developer.service.business.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiao.lai on 15/12/22.
 */
@Service
public class UserServiceImpl implements UserService{

    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    public UserInfo getUserById(int id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setUname("哈哈哈哈");
        userInfo.setUnumber(1);

        logger.debug("测试数据的唯一");
        return userInfo;
    }

    public List<UserInfo> getUsers() {
        return null;
    }

    public int insert(UserInfo userInfo) {
        return 0;
    }
}
