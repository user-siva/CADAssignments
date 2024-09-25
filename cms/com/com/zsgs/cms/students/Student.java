package com.zsgs.cms.students;

public class Student {
    private String name;
    private String studentId;
    private String course;

    public Student(String name, String studentId, String course) {
        this.name = name;
        this.studentId = studentId;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
