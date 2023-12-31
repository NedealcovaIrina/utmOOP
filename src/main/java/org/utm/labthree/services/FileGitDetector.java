package org.utm.labthree.services;

import org.utm.labthree.utils.DateHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileGitDetector extends GitDetector {

    private List<String> changeMessages = new ArrayList<>();

    private long snapshotTime = System.currentTimeMillis();

    private final Map<String, Long> fileLastModifiedMap = new HashMap<>();


    public FileGitDetector(String folderPath) {
        super(folderPath);
    }

    @Override
    public void scanDirectory() {
        File[] listOfFiles = getListOfFiles();
        if (listOfFiles == null) return;

        changeMessages = new ArrayList<>();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                long lastModified = file.lastModified();
                if (fileLastModifiedMap.containsKey(file.getName())) {
                    if (fileLastModifiedMap.get(file.getName()) != lastModified) {
                        changeMessages.add(file.getName() + " - Changed");
                    } else {
                        changeMessages.add(file.getName() + " - No Change");
                    }
                } else {
                    changeMessages.add(file.getName() + " - Added");
                }
            }
        }

        for (String fileName : new HashMap<>(fileLastModifiedMap).keySet()) {
            File file = new File(folderPath + "/" + fileName);
            if (!file.exists()) {
                changeMessages.add(fileName + " - Deleted");
            }
        }
    }

    public void commit() {
        File[] listOfFiles = getListOfFiles();
        if (listOfFiles == null) return;

        for (File file : listOfFiles) {
            if (file.isFile()) {
                long lastModified = file.lastModified();
                fileLastModifiedMap.put(file.getName(), lastModified);
            }
        }

        snapshotTime = System.currentTimeMillis();
        System.out.println("Created Snapshot at: " + DateHelper.formatDate(snapshotTime));
    }

    public void info(String fileName) {
        var fileService = new FileService(folderPath);
        fileService.info(fileName);
    }

    public void status() {
        if (fileLastModifiedMap.isEmpty()) {
            System.out.println("There're no any snapshots. You have to execute command commit.");
            return;
        }

        scanDirectory();

        System.out.println("Created Snapshot at: " + DateHelper.formatDate(snapshotTime));
        for (String message : changeMessages) {
            System.out.println(message);
        }
    }

}
