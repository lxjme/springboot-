package com.lxj.com_lxj_student_info.dao;


import com.lxj.com_lxj_student_info.pojo.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * UserDao
 */
public interface UserDao extends JpaRepository<User, Integer> {

    @Query("select t from User t where t.user_name = :user_name and t.password = :password")
    public User queryByNamePwd(@Param("user_name") String user_name, @Param("password") String password);
    
}