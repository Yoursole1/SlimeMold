package me.yoursole;

import me.yoursole.processor.MST;
import me.yoursole.processor.Point;
import me.yoursole.processor.SlimeDetector;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {


//        final File file = new File("input_slime.jpg");
//        final BufferedImage image = ImageIO.read(file);
//
//        final BufferedImage edgeDetected = new SlimeDetector(image).image();
//        File outputfile = new File("output_slime.jpg");
//        ImageIO.write(edgeDetected, "jpg", outputfile);


        MST mst = new MST(new ArrayList<>(){{
            add(new Point(0, 0));
            add(new Point(1,2));
            add(new Point(-2, 4));
            add(new Point(5, 9));
        }});

        System.out.println(mst.calculate());
    }
}
