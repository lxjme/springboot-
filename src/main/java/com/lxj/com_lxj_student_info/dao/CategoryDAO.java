package com.lxj.com_lxj_student_info.dao;

import com.lxj.com_lxj_student_info.pojo.Category;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CategoryDAO
 */
public interface CategoryDAO extends JpaRepository<Category,Integer> {

    
}