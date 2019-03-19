package com.lxj.com_lxj_student_info.controller;

import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.lxj.com_lxj_student_info.dao.UserDao;
import com.lxj.com_lxj_student_info.pojo.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * AuthController
 */
@RestController
public class AuthController {

    @Autowired
    UserDao userDao;

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    @ResponseBody
    @PostMapping(value="/loginProcess",produces = "application/json;charset=UTF-8")
    public String loginProcess(@RequestParam String user_name, @RequestParam String password, HttpSession session) {
        logger.info("----------------------------------");
        logger.info(user_name);
        logger.info(password);
        User user = userDao.queryByNamePwd(user_name, password);
        JSONObject result = new JSONObject();
        
        if(null == user) {
            // 登录失败
            result.put("msg","用户名或密码错误！");
            result.put("status",-1);
        } else {
            // 登录成功
            session.setAttribute("user_name", user.getUser_name());
            session.setAttribute("user_id", user.getId());
            result.put("msg", "登录成功");
            result.put("status", 1);
            result.put("url","/index");
        }

        return result.toJSONString();
    }
}