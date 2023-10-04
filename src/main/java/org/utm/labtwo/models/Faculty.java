package org.utm.labtwo.models;

import org.utm.labtwo.enums.StudyField;

import java.util.ArrayList;
import java.util.List;

public class Faculty {

    private String name;
    private String abbreviation;
    private StudyField field;
    private List<Student> enrolledStudents = new ArrayList<>();
    private List<Student> graduatedStudents = new ArrayList<>();

    public Faculty(String name, String abbreviation, StudyField studyField) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.field = studyField;
    }

    public void addStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void graduateStudent(Student student) {
        enrolledStudents.remove(student);
        graduatedStudents.add(student);
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public List<Student> getGraduatedStudents() {
        return graduatedStudents;
    }

    public boolean containsStudent(Student student) {
        return enrolledStudents.contains(student);
    }


    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public StudyField getField() {
        return field;
    }

    public void setField(StudyField field) {
        this.field = field;
    }

}