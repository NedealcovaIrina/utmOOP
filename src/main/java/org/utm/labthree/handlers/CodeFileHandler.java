package org.utm.labthree.handlers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CodeFileHandler implements FileTypeHandler {
    @Override
    public void info(File file) {
        try {
            var lines = Files.readAllLines(file.toPath());
            var content = String.join(" ", lines);

            int classCount = countMatches(content, "\\bclass\\b");
            int methodCount = countMatches(content, "(public|protected|private|static|\\s) +[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *\\{? *\\n?");

            System.out.println("Line Count: " + lines.size());
            System.out.println("Class Count: " + classCount);
            System.out.println("Method Count: " + methodCount);

        } catch (IOException e) {
            System.err.println("An error occurred while processing the file: " + e.getMessage());
        }
    }

    private int countMatches(String content, String regex) {
        var pattern = Pattern.compile(regex);
        var matcher = pattern.matcher(content);

        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
