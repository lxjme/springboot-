package com.lxj.com_lxj_student_info.dao;

import com.lxj.com_lxj_student_info.pojo.Grade;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * GradeDao
 */
public interface GradeDao extends JpaRepository<Grade, Integer> {

    
}