package com.zsgs.cms.faculty;

import java.util.ArrayList;
import java.util.List;

public class FacultyManager {
    private List<Faculty> faculties;

    public FacultyManager() {
        this.faculties = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public Faculty searchById(String facultyId) {
        for (Faculty faculty : faculties) {
            if (faculty.getFacultyId().equals(facultyId)) {
                return faculty;
            }
        }
        return null;
    }

    public List<Faculty> getAllFaculties() {
        return faculties;
    }
}
