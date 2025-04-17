package com.support.school.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Grade")
public class GradeModel {

    @Id
    private String id;

    private String grade;

    private String mayorId;

    public GradeModel() {
    }

    public GradeModel(String id, String grade, String mayorId) {
        this.id = id;
        this.grade = grade;
        this.mayorId = mayorId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMayorId() {
        return mayorId;
    }

    public void setMayorId(String mayorId) {
        this.mayorId = mayorId;
    }
}

