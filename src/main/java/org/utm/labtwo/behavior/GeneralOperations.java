package org.utm.labtwo.behavior;

import org.utm.labtwo.models.Faculty;
import org.utm.labtwo.models.University;

import java.util.Scanner;

public class GeneralOperations {

    public static void handleGeneralOptions(Scanner scanner, University university) {
        System.out.println("General operations");
        System.out.println("What do you want to do?");
        System.out.println();
        System.out.println("nf/<faculty name>/<faculty abbreviation>/<field> - create faculty");
        System.out.println("ss/<student email> - search student and show faculty");
        System.out.println("df - display faculties");
        System.out.println("df/<field> - display all faculties of a field");
        System.out.println();
        System.out.println("b - Back");
        System.out.println("q - Quit Program");

        String command = scanner.nextLine();
        String[] parts = command.split("/");

        switch (parts[0]) {
            case "nf" -> {
                if (parts.length != 4) {
                    System.out.println("Incorrect command. Enter data in the format: nf/<faculty name>/<faculty abbreviation>/<field>");
                } else {
                    var status = university.createFaculty(parts[1], parts[2], parts[3]);
                    if (status) {
                        System.out.println("The faculty is created");
                    }else {
                        System.out.println("Error in creating faculty");
                    }
                }
            }
            case "ss" -> {
                if (parts.length != 2) {
                    System.out.println("Incorrect command. Enter data in the format: ss/<student email>");
                } else {
                    Faculty faculty = university.findFacultyByStudentEmail(parts[1]);
                    if (faculty != null) {
                        System.out.println("Student belongs to the faculty " + faculty.getAbbreviation());
                    } else {
                        System.out.println("Student not found in faculties.");
                    }
                }
            }
            case "df" -> {
                if (parts.length == 1) {
                    university.displayFaculties();
                } else if (parts.length == 2) {
                    university.displayFacultiesByField(parts[1]);
                } else {
                    System.out.println("Incorrect command. Use df or df/<field>.");
                }
            }
            default -> System.out.println("Incorrect command. Repeat, please.");
        }
    }
}
