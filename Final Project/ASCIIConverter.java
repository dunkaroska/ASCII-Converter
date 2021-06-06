
/**
 * Write a description of class ASCIIConverter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class ASCIIConverter 
{
    // instance variables
    private int width;
    private int height;
    private Color[][] RGB;
    private int[][] brightnessVals;
    private char[][] ASCIIchar;
    private BufferedImage image;

    /**
     * Constructor for objects of class Test
     */
    public ASCIIConverter()
    {
        try 
        {
            File input = askUserForFile();
            image = ImageIO.read(input);
            width  = image.getWidth();
            height = image.getHeight();
            RGB = new Color[width][height];
            brightnessVals = new int[width][height];
            ASCIIchar = new char[width][height];
        }
        catch (Exception e) {System.out.println ("Try again!");}
    }
    //
    public void printDimensions()
    {
        System.out.println (width + " x " + height);
    }
    // creates a 2D array of RGB values
    public void storeRGB()
    {
        for(int x = 0; x < width; x++)
        {
            for(int y = 0; y < height; y++)
            {
                Color color = new Color (image.getRGB(x, y));
                RGB[x][y] = color;
            }
        }
    }
    //  
    public void RGBtoBrightness()
    {
        for(int x = 0; x < width; x++)
        {
            for(int y = 0; y < height; y++)
            {
                int redVal = RGB[x][y].getRed();
                int blueVal = RGB[x][y].getBlue();
                int greenVal = RGB[x][y].getGreen();
                brightnessVals[x][y] = (redVal + blueVal + greenVal)/3;
            }
        }
    }
    // 
    public void RGBtoMinMax()
    {
        for(int x = 0; x < width; x++)
        {
            for(int y = 0; y < height; y++)
            {
                int redVal = RGB[x][y].getRed();
                int blueVal = RGB[x][y].getBlue();
                int greenVal = RGB[x][y].getGreen();
                brightnessVals[x][y] = Math.max(Math.max(redVal, blueVal), greenVal) + Math.min(Math.min(redVal, blueVal), greenVal);
            }
        } 
    }

    public void RGBtoLuminosity1()
    {
        for(int x = 0; x < width; x++)
        {
            for(int y = 0; y < height; y++)
            {
                int redVal = RGB[x][y].getRed();
                int blueVal = RGB[x][y].getBlue();
                int greenVal = RGB[x][y].getGreen();
                brightnessVals[x][y] = (int)(0.2126 * redVal) + (int)(0.0722 * blueVal) + (int)(0.7152 * (greenVal));
            }
        } 
    }

    public void RGBtoLuminosity2()
    {
        for(int x = 0; x < width; x++)
        {
            for(int y = 0; y < height; y++)
            {
                int redVal = RGB[x][y].getRed();
                int blueVal = RGB[x][y].getBlue();
                int greenVal = RGB[x][y].getGreen();
                brightnessVals[x][y] = (int)Math.sqrt(0.299 * Math.pow(redVal, 2)) + (int)Math.sqrt(0.114 * Math.pow(blueVal, 2)) +  (int)Math.sqrt(0.587 * Math.pow(greenVal, 2));
            }
        } 
    }
    // converts the the brightness/luminosity/etc. value to a corresponding ASCII character
    public void ASCIIConverter()
    {
        String ASCII = "`^\",:;Il!i~+_-?][}{1)(|\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$";
        for(int x = 0; x < width; x++)
        {
            for(int y = 0; y < height; y++)
            {
                int index = (int)brightnessVals[x][y]/20;
                ASCIIchar[x][y] = ASCII.charAt(index);
            }
        }
    }

    public void ASCIItoFile()
    {
        try {
            FileWriter myWriter = new FileWriter("output.txt");
            for(int y = 0; y < height; y++)
            {
                for(int x = 0; x < width; x++)
                {
                    myWriter.write(ASCIIchar[x][y]);
                    myWriter.write(ASCIIchar[x][y]);
                    myWriter.write(ASCIIchar[x][y]);
                }
                myWriter.write("\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Wasn't able to create your file lmao");
        }
    }
    // prints out the ASCII image
    public void printASCII()
    {
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                System.out.print (ASCIIchar[x][y]);
                System.out.print (ASCIIchar[x][y]);
                System.out.print (ASCIIchar[x][y]);
            }
            System.out.println ("");
        }
    }

    public File askUserForFile()
    {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println ("Welcome, friend, to Dune's ASCII programming extravaganza!");
            System.out.println ("I hope you've put your image in the Final Project folder!");
            System.out.println ("If you don't have one, type in \"example.jpeg\" If you do, tell me the name of it!");
            File input = new File(scanner.next());
            return input;
        }
        catch(Exception e)
        {
            System.out.println ("Your file doesn't exist... Please try again ?");
            return null;
        }
    }

    public void run()
    {
        try {
            resizeImage();
            storeRGB();
            askUserForFormula();
            ASCIIConverter();
            askUserForPrintLocation();
        }
        catch (Exception e)
        {
            System.out.println ("Something went wrong. Please try again.");
        }
    }

    public void askUserForPrintLocation()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println ("Press 1 if you would like the ASCII image to be displayed in the terminal widnow.");
        System.out.println ("Press 2 if you would like the ASCII image to be displayed as output.txt in the Final Project folder.");
        int place = scanner.nextInt();
        if (place == 1)
        {
            printASCII();
        }
        else if (place == 2)
        {
            ASCIItoFile();
        }
        else
        {
          System.out.println ("Please try again and input either a 1 or a 2.");  
        }
    }

    public void askUserForFormula()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println ("Which way would you like your image displayed?");
        System.out.println ("Press 1 for converting RGB to brightness by averaging the values");
        System.out.println ("Press 2 for converting RGB by adding the minimum and maximum values");
        System.out.println ("Press 3 for converting RGB to luminosity by using a formula about how humans percieve color");
        System.out.println ("Press 4 for converting RGB to luminosity by using a different formula on how humans percieve color");
        int input = scanner.nextInt();
        switch (input) {
            case 1: RGBtoBrightness();
            break;
            case 2 : RGBtoMinMax();
            break;
            case 3 : RGBtoLuminosity1();
            break;
            case 4 : RGBtoLuminosity2();
            break;
            default : System.out.println ("Try again. Your number was not an option.");
        }
    }

    public void resizeImage()
    {
        BufferedImage newImage = new BufferedImage (50, 50, BufferedImage.TYPE_INT_RGB);
        Graphics g = newImage.createGraphics();
        g.drawImage(image, 0, 0, 50, 50, null);
        g.dispose();
        image = newImage;
        height = image.getHeight();
        width = image.getWidth();
    }
}
 