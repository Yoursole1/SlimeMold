package me.yoursole.processor;

import java.awt.*;
import java.awt.image.BufferedImage;

public record SlimeDetector(BufferedImage image) {

    public SlimeDetector(BufferedImage image) {
        this.image = image;
        detect();
    }

    private void detect() {
        for (int x = 0; x < this.image.getWidth(); x++) {
            for (int y = 0; y < this.image.getHeight(); y++) {
                final int clr = this.image.getRGB(x, y);
                int red = (clr & 0x00ff0000) >> 16;
                int green = (clr & 0x0000ff00) >> 8;
                int blue = clr & 0x000000ff;

                float[] hsv = new float[3];
                Color.RGBtoHSB(red, green, blue, hsv);

                float hue = hsv[0];

                if (hue > 45/360F && hue < 71/360F) {
                    red = 0;
                    green = 0;
                    blue = 0;
                } else {
                    red = 255;
                    green = 255;
                    blue = 255;
                }

                this.image.setRGB(x, y, new Color(red, green, blue).getRGB());
            }
        }
    }
}
