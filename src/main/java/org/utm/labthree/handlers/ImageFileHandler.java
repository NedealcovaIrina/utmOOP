package org.utm.labthree.handlers;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ImageFileHandler implements FileTypeHandler {
    @Override
    public void info(File file) {
        try {
            var image = ImageIO.read(file);
            System.out.println("Image Dimensions: " + image.getWidth() + "x" + image.getHeight());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
