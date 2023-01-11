package me.yoursole.processor;

import java.awt.*;
import java.awt.image.BufferedImage;

public record SlimeDetector(BufferedImage image) {

    // Constructor that takes a BufferedImage as input
    public SlimeDetector(BufferedImage image) {
        // Initialize the input image
        this.image = image;
        // Detect slimes in the image
        detect();
    }

    // Method that detects slimes in the input image
    private void detect() {
        // Iterate over each pixel in the image
        for (int x = 0; x < this.image.getWidth(); x++) {
            for (int y = 0; y < this.image.getHeight(); y++) {
                // Get the color of the pixel
                final int clr = this.image.getRGB(x, y);
                int red = (clr & 0x00ff0000) >> 16;
                int green = (clr & 0x0000ff00) >> 8;
                int blue = clr & 0x000000ff;

                // Convert the pixel's RGB color to HSB
                float[] hsv = new float[3];
                Color.RGBtoHSB(red, green, blue, hsv);

                // Get the hue of the pixel
                float hue = hsv[0];

                // If the hue is within the range of 45/360 to 71/360,
                // set the pixel's color to black. Otherwise, set it to white.
                if (hue > 45/360F && hue < 71/360F) {
                    red = 0;
                    green = 0;
                    blue = 0;
                } else {
                    red = 255;
                    green = 255;
                    blue = 255;
                }

                // Update the pixel's color in the image
                this.image.setRGB(x, y, new Color(red, green, blue).getRGB());
            }
        }
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 4c146d77b6d68c54d63b4d5d1c4c9b13b18acff7
