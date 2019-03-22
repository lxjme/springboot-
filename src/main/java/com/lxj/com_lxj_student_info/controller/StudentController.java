package com.lxj.com_lxj_student_info.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.lxj.com_lxj_student_info.dao.StudentDao;
import com.lxj.com_lxj_student_info.pojo.Student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

        int_page = int_page < 0 ? 0 : int_page - 1;
        // Sort sort = new Sort(Sort.Direction.DESC, "stuId");
        // Pageable pageable = new PageRequest(int_page, nums, sort);
        // Page<Student> page_student = studentDao.findAll(pageable);

        // int total_nums = (int) page_student.getTotalElements();

        // // List<Student> student_list = studentDao.getListByPage(start, nums);
        // // System.out.println().toString());
        // System.out.println(page_student);


        List<Object> student_list = studentDao.selectListStudent(int_page * nums, nums);

        List<Object> res_list = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        for (Object o : student_list) {
            Student stu = new Student();

            Object[] rowArray = (Object[]) o;
            // System.out.println(Arrays.toString(rowArray));
            //
            stu.setStuId((int) rowArray[0]);
            stu.setStuNo((String) rowArray[1]);
            stu.setStuName((String) rowArray[2]);
            stu.setSex((String) rowArray[3]);
            String date_str = sdf.format(rowArray[4]);
            stu.setDateTime(date_str);
            stu.setGradeId((int) rowArray[5]);
            stu.setGradeName((String) rowArray[8]);
            stu.setEmail((String) rowArray[6]);
            stu.setStuDesc((String) rowArray[7]);

            res_list.add(stu);

        }

        JSONObject result = new JSONObject();

        result.put("total", studentDao.selectTotal());
        result.put("rows", res_list);
        return result.toJSONString();
    }

    /**
     * 保存
     * 
     * @throws ParseException
     */
    @ResponseBody
    @PostMapping("/studentSave")
    public Map<String, Object> studentSave(HttpServletRequest req) throws ParseException {
        
        String stuNo = req.getParameter("stuNo");
        int gradeId = Integer.parseInt(req.getParameter("gradeId"));
        String stuName = req.getParameter("stuName");
        String sex = req.getParameter("sex");
        String email = req.getParameter("email");
        String stuDesc = req.getParameter("stuDesc");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = format.parse(req.getParameter("dateTime"));


        Student s = new Student();
        s.setStuNo(stuNo);
        s.setGradeId(gradeId);
        s.setStuName(stuName);
        s.setSex(sex);
        s.setEmail(email);
        s.setStuDesc(stuDesc);
        s.setBirthday(birthday);

        if (req.getParameter("stuId") != null) {
            // 修改
            s.setStuId(Integer.parseInt(req.getParameter("stuId")));
        }

        System.out.println();
        Student res_s = studentDao.save(s);
        System.out.println(res_s);
        Map<String, Object> result = new HashMap<>();
        if(res_s != null) {
            result.put("msg", "保存成功！");
            result.put("status",1);
        } else {
            result.put("msg", "保存失败！");
            result.put("status", -1);
        }
        return result;
    }


    /**
     * 删除学生
     */
    @ResponseBody
    @PostMapping("/studentDelete")
    public Map<String, String> studentDelete(HttpServletRequest req) {
        Map<String, String> result = new HashMap<>();

        if(req.getParameter("delIds") != null) {

            int delNums = studentDao.delStudentByIds(req.getParameter("delIds"));
            if(delNums > 0) {
                result.put("status", "1");
                result.put("msg", "删除成功");
            } else {
                result.put("status", "-2");
                result.put("msg", "删除失败");
            }
        } else {
            result.put("status", "-1");
            result.put("msg", "请选择要删除的数据！");
        }
        return result;
    }
    
}