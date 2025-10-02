package com.mycompany.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class IconLoader {
    public static ImageIcon loadIcon(String resourceName, int size) {
        try {
            BufferedImage img = ImageIO.read(IconLoader.class.getResource("/" + resourceName));
            Image scaled = img.getScaledInstance(size, size, Image.SCALE_SMOOTH);
            return new ImageIcon(scaled);
        } catch (IOException | IllegalArgumentException e) {
            return null;
        }
    }
}
