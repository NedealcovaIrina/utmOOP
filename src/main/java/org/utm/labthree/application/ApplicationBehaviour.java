package org.utm.labthree.application;

import java.util.Scanner;

public class ApplicationBehaviour {

    private final String folderPath;

    public ApplicationBehaviour(String folderPath) {
        this.folderPath = folderPath;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter command (commit, info, status, exit):");
            String command = scanner.nextLine();
            switch (command) {
                case "commit" -> System.out.println("Commit:");
                case "info" -> System.out.println("Info:");
                case "status" -> System.out.println("Status:");
                case "exit" -> {
                    scanner.close();
                    System.out.println("Exit");
                    System.exit(0);
                }
                default -> System.out.println("Invalid command.");
            }
        }
    }

}
