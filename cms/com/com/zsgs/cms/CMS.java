package com.zsgs.cms;

import com.zsgs.cms.courses.Course;
import com.zsgs.cms.courses.CourseManager;
import com.zsgs.cms.students.Student;
import com.zsgs.cms.students.StudentManager;
import com.zsgs.cms.faculty.Faculty;
import com.zsgs.cms.faculty.FacultyManager;

public class CMS {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        FacultyManager facultyManager = new FacultyManager();
        CourseManager courseManager = new CourseManager();

        studentManager.addStudent(new Student("Siva", "S001", "C001"));
        studentManager.addStudent(new Student("Ganesh", "S002", "C002"));

        facultyManager.addFaculty(new Faculty("Dr. Jeeva", "F001", "Computer Science"));
        facultyManager.addFaculty(new Faculty("Dr. David", "F002", "Mathematics"));

        courseManager.addCourse(new Course("C001", "Data Structures", "Dr. Jeeva"));
        courseManager.addCourse(new Course("C002", "Calculus", "Dr. David"));

        Student student = studentManager.searchById("S001");
        if (student != null) {
            System.out.println("Student Found: " + student.getName() + ", Course: " + student.getCourse());
        }

        Faculty faculty = facultyManager.searchById("F001");
        if (faculty != null) {
            System.out.println("Faculty Found: " + faculty.getName() + ", Department: " + faculty.getDepartment());
        }

        Course course = courseManager.searchById("C001");
        if (course != null) {
            System.out.println("Course Found: " + course.getCourseName() + ", Faculty: " + course.getFacultyName());
        }
    }
}
