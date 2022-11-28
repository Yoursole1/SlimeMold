package me.yoursole;

import me.yoursole.processor.SlimeDetector;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {


        final File file = new File("input_slime.jpg");
        final BufferedImage image = ImageIO.read(file);

        final BufferedImage edgeDetected = new SlimeDetector(image).image();
        File outputfile = new File("output_slime.jpg");
        ImageIO.write(edgeDetected, "jpg", outputfile);

    }
}
