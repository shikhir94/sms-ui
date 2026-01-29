package com.example.schoolmanagement.dto;

import java.util.List;

public class TeacherDto {

    private Long id;
    private String name;
    private List<String> subjects;

    public TeacherDto() {}

    public TeacherDto(Long id, String name, List<String> subjects) {
        this.id = id;
        this.name = name;
        this.subjects = subjects;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
}