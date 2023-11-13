package org.utm.labthree.services;

import java.io.File;
import org.utm.labthree.handlers.FileTypeHandler;
import org.utm.labthree.handlers.ImageFileHandler;
import org.utm.labthree.handlers.TextFileHandler;
import org.utm.labthree.handlers.CodeFileHandler;

public class FileService {

    private final String folderPath;

    public FileService(String folderPath) {
        this.folderPath = folderPath;
    }

    public void info(String fileName) {
        var file = new File(folderPath + "/" + fileName);
        if (file.exists()) {
            FileTypeHandler handler = getHandlerForFile(file);
            if (handler != null) {
                handler.info(file);
            } else {
                System.out.println("No handler for this file type.");
            }
        } else {
            System.out.println(fileName + " does not exist.");
        }
    }

    private FileTypeHandler getHandlerForFile(File file) {
        String extension = getFileExtension(file);
        return switch (extension) {
            case "png", "jpg" -> new ImageFileHandler();
            case "txt" -> new TextFileHandler();
            case "py", "java" -> new CodeFileHandler();
            default -> null;
        };
    }

    private String getFileExtension(File file) {
        var fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }
}
