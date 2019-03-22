package com.lxj.com_lxj_student_info.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * GradeController
 */
@RestController
public class GradeController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    GradeDao gradeDao;

    private JSONObject result = new JSONObject();



    @PostMapping("/gradeList")
    public String gradeList(@RequestParam String page, @RequestParam String rows) {
        int nums = Integer.parseInt(rows);
        int int_page = Integer.parseInt(page);

        int_page = int_page < 0 ? 0 : int_page - 1;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(int_page, nums, sort);
        Page<Grade> page_grade = gradeDao.findAll(pageable);

        int total_nums = (int) page_grade.getTotalElements();

        

        result.put("total", total_nums);
        result.put("rows", page_grade.getContent());
        // result
        return result.toJSONString();
    }

    @PostMapping("/gradeComboList")
    public List<Map<String, String>> gradeComboList() {
        List<Map<String, Object>> grade_list =  gradeDao.gradeListName();

        List<Map<String, String>> res_list = new ArrayList<>();

        for (Map<String, Object> m : grade_list) {
        Map<String, String> map = new HashMap<>();
            map.put("id", m.get("0").toString());
            map.put("gradeName", m.get("1").toString());
            res_list.add(map);
        }
        return res_list;
    }

    /**
     * 添加/更新
     * 
     * @return
     */
    @PostMapping("/gradeSave")
    public Map<String, String> gradeSave(HttpServletRequest req) {
        // System.out.println(req.get);
        String gradeName = req.getParameter("gradeName");
        String gradeDesc = req.getParameter("gradeDesc");

        

        Grade grade = new Grade();
        grade.setGradeName(gradeName);
        grade.setGradeDesc(gradeDesc);

        if(req.getParameter("id") != null) {
            grade.setId(Integer.parseInt(req.getParameter("id")));
        }

        Map<String, String> result = new HashMap<>();
        
        if(gradeDao.save(grade) != null) {
            result.put("msg","操作成功");
            result.put("status", "1");
        } else {
            result.put("msg", "操作失败");
            result.put("status", "-1");
        }

        return result;
     }

     @PostMapping("/gradeDelete")
     public Map<String, String> gradeDelete(String delIds) {
        Map<String, String> result = new HashMap<>();

        if (delIds != null) {

            int delNums = gradeDao.delGradeByIds(delIds);
            if (delNums > 0) {
                result.put("status", "1");
                result.put("msg", "删除成功");
                result.put("delNums", String.valueOf(delNums));
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