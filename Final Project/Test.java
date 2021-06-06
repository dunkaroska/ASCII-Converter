
/**
 * This class should be able to print out the width and height for a select test image.
 *
 * 
 * Dune Zawadzki
 */
import java.io.File;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Test 
{
    // instance variables
    private int width;
    private int height;
    private BufferedImage image;

    /**
     * Constructor for objects of class Test
     */
    public Test()
    {
        try 
        {
           File input = new File("ascii-pineapple.jpeg"); 
           image = ImageIO.read(input);
           width  = image.getWidth();
           height = image.getHeight();
        }
        catch (Exception e) {System.out.println ("Try again!");}
    }

    /**
     * Prints out the dimensions of the image
     */
    public void printDimensions()
    {
        System.out.println (width + " x " + height);
    }
}
