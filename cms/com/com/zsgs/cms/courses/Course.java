package com.zsgs.cms.courses;

public class Course {
    private String courseId;
    private String courseName;
    private String facultyName;

    public Course(String courseId, String courseName, String facultyName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.facultyName = facultyName;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
}
