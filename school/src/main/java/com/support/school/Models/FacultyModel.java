package com.support.school.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Faculty")
public class FacultyModel {

    @Id
    private String id;

    private String facultyName;

    public FacultyModel() {
    }

    public FacultyModel(String id, String facultyName) {
        this.id = id;
        this.facultyName = facultyName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
}
