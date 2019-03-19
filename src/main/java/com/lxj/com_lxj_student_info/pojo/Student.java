package com.lxj.com_lxj_student_info.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Student
 */
@Entity
@Table(name="t_student")
@JsonIgnoreProperties({ "handler", "hibernateLazyInitializer" })
public class Student {
    @Id
    @Column(name = "stuId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stuId;

    @Column(name="stuNo")
    private String stuNo;

    @Column(name = "stuName")
    private String stuName;

    @Column(name="sex")
    private String sex;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name="gradeId")
    private int gradeId;

    @Column(name="email")
    private String email;
    
    @Column(name="stuDesc")
    private String stuDesc;

    @Transient
    private String gradeName;

    


    /**
     * @return the stuId
     */
    public int getStuId() {
        return stuId;
    }

    /**
     * @param stuId the stuId to set
     */
    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    /**
     * @return the stuNo
     */
    public String getStuNo() {
        return stuNo;
    }

    /**
     * @param stuNo the stuNo to set
     */
    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    /**
     * @return the stuName
     */
    public String getStuName() {
        return stuName;
    }

    /**
     * @param stuName the stuName to set
     */
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the gradeId
     */
    public int getGradeId() {
        return gradeId;
    }

    /**
     * @param gradeId the gradeId to set
     */
    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the stuDesc
     */
    public String getStuDesc() {
        return stuDesc;
    }

    /**
     * @param stuDesc the stuDesc to set
     */
    public void setStuDesc(String stuDesc) {
        this.stuDesc = stuDesc;
    }

    /**
     * @return the gradeName
     */
    public String getGradeName() {
        return gradeName;
    }

    /**
     * @param gradeName the gradeName to set
     */
    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }


    
}