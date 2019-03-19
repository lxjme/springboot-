package com.lxj.com_lxj_student_info.controller;

import com.alibaba.fastjson.JSONObject;
import com.lxj.com_lxj_student_info.dao.GradeDao;
import com.lxj.com_lxj_student_info.pojo.Grade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * GradeController
 */
@RestController
public class GradeController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    GradeDao gradeDao;

    @PostMapping("/gradeList")
    public String gradeList(@RequestParam String page, @RequestParam String rows) {
        int nums = Integer.parseInt(rows);
        int int_page = Integer.parseInt(page);

        int_page = int_page < 0 ? 0 : int_page - 1;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(int_page, nums, sort);
        Page<Grade> page_grade = gradeDao.findAll(pageable);

        int total_nums = (int) page_grade.getTotalElements();

        JSONObject result = new JSONObject();

        result.put("total", total_nums);
        result.put("rows", page_grade.getContent());
        // result
        return result.toJSONString();
    }
    
}