package com.developer.controller;

import com.developer.dao.model.UserInfo;
import com.developer.service.business.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xiao.lai on 15/12/22.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/showInfo/{userId}")
    public String showUserInfo(ModelMap modelMap, @PathVariable int userId){
        UserInfo userInfo = userService.getUserById(userId);
        modelMap.addAttribute("userInfo", userInfo);
        return "/user/showInfo";
    }

    @RequestMapping("/showInfos.api")
    @ResponseBody
    public Object showUserInfos(){
        List<UserInfo> userInfos = userService.getUsers();
        return userInfos;
    }


    @RequestMapping("/test1/{userId}/{pageNum}/{pageSize}")
    public String showUserInfo(@PathVariable int userId, @PathVariable int pageNum, @PathVariable int pageSize){
        return "返回url链接中，带参数传递的方式代码。@PathVariable";
    }


    @RequestMapping(value= "/test2.api", method = RequestMethod.GET)
    @ResponseBody
    public String test2(@RequestParam(value = "uid", required = true) Integer uid){
        return "@RequestParam,uid是"+uid;
    }

}
