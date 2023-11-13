package org.utm.labthree.handlers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class TextFileHandler implements FileTypeHandler {
    @Override
    public void info(File file) {
        try {
            var lines = Files.readAllLines(file.toPath());
            System.out.println("Line Count: " + lines.size());
            System.out.println("Word Count: " + lines.stream().mapToInt(line -> line.split("\\s+").length).sum());
            System.out.println("Character Count: " + lines.stream().mapToInt(String::length).sum());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
