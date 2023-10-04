package org.utm.labtwo.behavior;

import org.utm.labtwo.models.University;

import java.util.Scanner;

public class CommandLineInterface {

    private final University university;

    public CommandLineInterface(University university) {
        this.university = university;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to TUM's student management system!");
            System.out.println("What do you want to do?");
            System.out.println();
            System.out.println("g - General operations");
            System.out.println("f - Faculty operations");
            System.out.println("s - Student operations");
            System.out.println();
            System.out.println("q - Quit Program");

            String option = scanner.nextLine();

            switch (option) {
                case "g" -> GeneralOperations.handleGeneralOptions(scanner, university);
                case "f" -> FacultyOperations.handleFacultyOptions(scanner, university);
                case "s" -> System.out.println("Student operations");
                case "q" -> {
                    System.out.println("Quit Program");
                    return;
                }
                default -> System.out.println("Incorrect selection. Please repeat.");
            }
        }
    }
}
