package org.utm.labthree;

import org.utm.labthree.application.ApplicationBehaviour;

public class Main {

    public static void main(String[] args) {
        ApplicationBehaviour applicationContext = new ApplicationBehaviour("src/main/resources/Files/");
        applicationContext.run();
    }
}