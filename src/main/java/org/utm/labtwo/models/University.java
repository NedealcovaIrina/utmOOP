package org.utm.labtwo.models;

import org.utm.labtwo.enums.StudyField;

import java.util.ArrayList;
import java.util.List;


public class University {

    private List<Faculty> faculties = new ArrayList<>();

    public boolean createFaculty(String name, String abbreviation, String field) {
        if (!StudyField.isValidField(field)) {
            System.out.println("Invalid field. Available fields: MECHANICAL_ENGINEERING, SOFTWARE_SYSTEMS_ENGINEERING, FOOD_TECHNOLOGY, URBANISM_ARCHITECTURE, VETERINARY_MEDICINE");
            return false;
        }

        // Convert the field to the StudyField enum
        StudyField studyField = StudyField.valueOf(field);

        Faculty faculty = new Faculty(name, abbreviation, studyField);
        faculties.add(faculty);

        return true;
    }

    public Faculty findFacultyByStudentEmail(String studentEmail) {
        for (Faculty faculty : faculties) {
            for (Student student : faculty.getEnrolledStudents()) {
                if (student.getEmail().equals(studentEmail)) {
                    return faculty;
                }
            }
        }
        return null;
    }

    public void displayFaculties() {
        System.out.println("Faculty list in the university:");
        for (Faculty faculty : faculties) {
            System.out.println(faculty.getAbbreviation() + " - " + faculty.getName());
        }
    }

    public void displayFacultiesByField(String field) {
        System.out.println("Faculties in the field of " + field + ":");
        try {
            StudyField studyField = StudyField.valueOf(field);
            for (Faculty faculty : faculties) {
                if (faculty.getField().equals(studyField)) {
                    System.out.println(faculty.getAbbreviation() + " - " + faculty.getName());
                }
            }
        }catch (IllegalArgumentException e) {
            System.out.println("Study Field is incorrect");
        }
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public Faculty findFacultyByAbbreviation(String abbreviation) {
        for (Faculty faculty : faculties) {
            if (faculty.getAbbreviation().equals(abbreviation)) {
                return faculty;
            }
        }
        return null;
    }

    public Student findStudentByEmail(String email) {
        for (Faculty faculty : faculties) {
            for (Student student : faculty.getEnrolledStudents()) {
                if (student.getEmail().equals(email)) {
                    return student;
                }
            }
        }
        return null;
    }

}


