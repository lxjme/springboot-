package com.lxj.com_lxj_student_info.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Grade
 */
@Entity
@Table(name="t_grade")
public class Grade {



    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="gradeName")
    private String gradeName;

    @Column(name="gradeDesc")
    private String gradeDesc;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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

    /**
     * @return the gradeDesc
     */
    public String getGradeDesc() {
        return gradeDesc;
    }

    /**
     * @param gradeDesc the gradeDesc to set
     */
    public void setGradeDesc(String gradeDesc) {
        this.gradeDesc = gradeDesc;
    }

    
}