package com.lxj.com_lxj_student_info.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.lxj.com_lxj_student_info.dao.StudentDao;
import com.lxj.com_lxj_student_info.pojo.Student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * StudentController
 */
@RestController
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    StudentDao studentDao;

    @ResponseBody
    @PostMapping("/studentList")
    public String studentList(@RequestParam String page, @RequestParam String rows) {


        logger.info(page);
        logger.info(rows);
        studentDao.findAll();
        // System.out.println(res.get);
        int nums = Integer.parseInt(rows);
        int int_page = Integer.parseInt(page);


        int_page = int_page < 0 ? 0 : int_page-1;
        // Sort sort = new Sort(Sort.Direction.DESC, "stuId");
        // Pageable pageable = new PageRequest(int_page, nums, sort);
        // Page<Student> page_student = studentDao.findAll(pageable);

        // int total_nums = (int) page_student.getTotalElements();

        // // List<Student> student_list = studentDao.getListByPage(start, nums);
        // // System.out.println().toString());
        // System.out.println(page_student);
        
        JSONObject result = new JSONObject();


        List<Object> student_list = studentDao.selectListStudent(int_page*nums, nums);

        List<Object> res_list = new ArrayList<>();

        for (Object o : student_list) {
            Student stu = new Student();

            Object[] rowArray = (Object[]) o;
            // 
            stu.setStuId((int) rowArray[0]);
            stu.setStuNo((String) rowArray[1]);
            stu.setStuName((String) rowArray[2]);
            stu.setSex((String) rowArray[3]);
            stu.setBirthday((Date) rowArray[4]);
            stu.setGradeName((String) rowArray[8]);
            stu.setEmail((String) rowArray[6]);
            stu.setStuDesc((String) rowArray[7]);

            res_list.add(stu);

        }

        result.put("total", studentDao.selectTotal());
        result.put("rows", res_list);
        // result
        return result.toJSONString();
    }
    
}