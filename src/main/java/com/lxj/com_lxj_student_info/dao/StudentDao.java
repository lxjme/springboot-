package com.lxj.com_lxj_student_info.dao;

import java.util.List;

import com.lxj.com_lxj_student_info.pojo.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * StudentDao
 */
public interface StudentDao extends JpaRepository<Student,Integer> {

    @Query(nativeQuery=true,value="select s.stuId, s.stuNo, s.stuName, s.sex,s.birthday,s.gradeId,s.email,s.stuDesc, g.gradeName from t_student s left join t_grade g on s.gradeId = g.id order by s.stuId desc limit ?1, ?2")
    public List<Object> selectListStudent(int start, int rows);

    @Query(nativeQuery = true, value = "select count(s.stuId) from t_student s left join t_grade g on s.gradeId = g.id")
    public int selectTotal();

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value="delete from t_student where stuId in (?1)")
    public int delStudentByIds(String ids);
    
}