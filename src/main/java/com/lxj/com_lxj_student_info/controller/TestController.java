package com.lxj.com_lxj_student_info.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * TestController
 */
@Controller
public class TestController {

    @GetMapping("/getMany")
    public String getMany() {
        return "getMany";
    }
}