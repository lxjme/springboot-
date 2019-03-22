package com.lxj.com_lxj_student_info.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * IndexController
 */
@Controller
public class IndexController {

    @GetMapping("/index")
    public String index(HttpSession session,Model m) {
        m.addAttribute("user_name", session.getAttribute("user_name"));
        return "index";
    }

    /**
     * 学生信息管理页面
     */
    @GetMapping("/studenManage")
    public String studenManage() {
        return "student_manage";
    }

    /**
     * 班级信息管理页面
     */
    @GetMapping("/gradeManage")
    public String gradeManage() {
        return "grade_manage";
    }


    /**
     * 退出
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user_name");
        return "redirect:/login";
    }
}