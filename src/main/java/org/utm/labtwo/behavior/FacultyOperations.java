package org.utm.labtwo.behavior;

import org.utm.labtwo.models.Faculty;
import org.utm.labtwo.models.Student;
import org.utm.labtwo.models.University;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class FacultyOperations {

    private final University university;

    public FacultyOperations(University university) {
        this.university = university;
    }

    public static void handleFacultyOptions(Scanner scanner, University university) {
        while (true) {

            System.out.println("Faculty operations");
            System.out.println("What do you want to do?");
            System.out.println();
            System.out.println("ns/<faculty abbreviation>/<first name>/<last name>/<email>/<day>/<month>/<year> - new student's enrollment");
            System.out.println("gs/<email> - student graduation");
            System.out.println("ds/<faculty abbreviation> - to show enrolled students");
            System.out.println("dg/<faculty abbreviation> - to show graduated students");
            System.out.println("bf/<faculty abbreviation>/<email> - check whether the student belongs to a faculty");
            System.out.println();
            System.out.println("b - Back");
            System.out.println("q - Quit Program");

            String command = scanner.nextLine();
            String[] parts = command.split("/");

            if (command.equals("b")) {
                break;
            }

            switch (parts[0]) {
                case "ns" -> {
                    if (parts.length != 8) {
                        System.out.println("Incorrect command. Enter data in the format: ns/<faculty abbreviation>/<first name>/<last name>/<email>/<day>/<month>/<year>");
                        continue;
                    }
                    String facultyAbbreviation = parts[1];
                    String firstName = parts[2];
                    String lastName = parts[3];
                    String email = parts[4];
                    int day = Integer.parseInt(parts[5]);
                    int month = Integer.parseInt(parts[6]);
                    int year = Integer.parseInt(parts[7]);
                    Date dateOfBirth = new Date(year, month, day);
                    Student newStudent = new Student(firstName, lastName, email, dateOfBirth);
                    Faculty targetFaculty = university.findFacultyByAbbreviation(facultyAbbreviation);
                    if (targetFaculty != null) {
                        targetFaculty.addStudent(newStudent);
                        System.out.println("Student is enrolled to the faculty " + targetFaculty.getName());
                    } else {
                        System.out.println("Faculty abbreviation " + facultyAbbreviation + " is not found.");
                    }
                }
                case "gs" -> {
                    if (parts.length != 2) {
                        System.out.println("Incorrect command. Enter students email in the format: gs/<email>");
                        continue;
                    }
                    String studentEmail = parts[1];
                    for (Faculty faculty : university.getFaculties()) {
                        for (Student student : faculty.getEnrolledStudents()) {
                            if (student.getEmail().equals(studentEmail)) {
                                faculty.graduateStudent(student);
                                System.out.println("Student " + studentEmail + " is graduated.");
                                return;
                            }
                        }
                    }
                    System.out.println("Student's email " + studentEmail + " is not found.");
                }
                case "ds" -> {
                    if (parts.length != 2) {
                        System.out.println("Incorrect command. Enter faculty abbreviation in the format: ds/<faculty abbreviation>");
                        continue;
                    }
                    String facultyAbbrev = parts[1];
                    Faculty targetFac = university.findFacultyByAbbreviation(facultyAbbrev);
                    if (targetFac != null) {
                        List<Student> enrolledStudents = targetFac.getEnrolledStudents();
                        System.out.println("Students enrolled to the faculty " + targetFac.getName() + ":");
                        for (Student student : enrolledStudents) {
                            System.out.println(student.getEmail() + " - " + student.getFirstName() + " " + student.getLastName());
                        }
                    } else {
                        System.out.println("Faculty abbreviation " + facultyAbbrev + " is not found.");
                    }
                }
                case "dg" -> {
                    if (parts.length != 2) {
                        System.out.println("Incorrect command. Enter faculty abbreviation in the format: dg/<faculty abbreviation>");
                        continue;
                    }
                    String facultyAbbreviation2 = parts[1];
                    Faculty targetFaculty2 = university.findFacultyByAbbreviation(facultyAbbreviation2);
                    if (targetFaculty2 != null) {
                        List<Student> graduatedStudents = targetFaculty2.getGraduatedStudents();
                        System.out.println("Graduated students " + targetFaculty2.getName() + ":");
                        for (Student student : graduatedStudents) {
                            System.out.println(student.getEmail() + " - " + student.getFirstName() + " " + student.getLastName());
                        }
                    } else {
                        System.out.println("Faculty abbreviation " + facultyAbbreviation2 + " is not found.");
                    }
                }
                case "bf" -> {
                    if (parts.length != 3) {
                        System.out.println("Incorrect command. Enter faculty abbreviation and student's email in the format of: bf/<faculty abbreviation>/<email>");
                        continue;
                    }
                    String facultyAbbreviation3 = parts[1];
                    String studentEmail3 = parts[2];
                    Faculty targetFaculty3 = university.findFacultyByAbbreviation(facultyAbbreviation3);
                    if (targetFaculty3 != null) {
                        Student targetStudent = university.findStudentByEmail(studentEmail3);
                        if (targetStudent != null && targetFaculty3.containsStudent(targetStudent)) {
                            System.out.println("Student's email " + studentEmail3 + " belongs to the faculty " + targetFaculty3.getName());
                        } else {
                            System.out.println("Student's email " + studentEmail3 + " doesn't belong to the faculty " + targetFaculty3.getName());
                        }
                    } else {
                        System.out.println("Faculty abbreviation  " + facultyAbbreviation3 + " is not found.");
                    }
                }
                default -> System.out.println("Incorrect command. Please repeat.");
            }
        }
    }
}