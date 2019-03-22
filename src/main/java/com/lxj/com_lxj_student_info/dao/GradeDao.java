package com.lxj.com_lxj_student_info.dao;

import java.util.List;
import java.util.Map;

import com.lxj.com_lxj_student_info.pojo.Grade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * GradeDao
 */
public interface GradeDao extends JpaRepository<Grade, Integer> {

    @Query("select new map(g.id, g.gradeName) from Grade g")
    public List<Map<String, Object>> gradeListName();

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from t_grade where id in (?1)")
    public int delGradeByIds(String ids);
}