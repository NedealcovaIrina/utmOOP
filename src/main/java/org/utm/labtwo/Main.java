package org.utm.labtwo;

import org.utm.labtwo.behavior.CommandLineInterface;
import org.utm.labtwo.models.University;

public class Main {

    public static void main(String[] args) {
        University university = new University();
        CommandLineInterface cli = new CommandLineInterface(university);
        cli.start();
    }
}