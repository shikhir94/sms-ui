package com.example.schoolmanagement.dto;

public class TimetableDto {

    private Long id;
    private Long classId;
    private Long teacherId;
    private Long dayId;
    private Integer period;
    private String subject;
    private String className;
    private String teacherName;

    public TimetableDto() {}

    public TimetableDto(Long id, Long classId, Long teacherId, Long dayId, Integer period, String subject, String className, String teacherName) {
        this.id = id;
        this.classId = classId;
        this.teacherId = teacherId;
        this.dayId = dayId;
        this.period = period;
        this.subject = subject;
        this.className = className;
        this.teacherName = teacherName;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getDayId() {
        return dayId;
    }

    public void setDayId(Long dayId) {
        this.dayId = dayId;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}