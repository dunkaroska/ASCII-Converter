
/**
 * Write a description of class ConverterDriver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class ConverterDriver
{
    public static void main()
    {
        //testing Test
        //Test funky = new Test();
        //funky.printDimensions();

        //testing Test2
        int x = 0;
        while (x == 0)
        {
        ASCIIConverter funky2 = new ASCIIConverter();
        funky2.run();
        Scanner scanner = new Scanner(System.in);
        System.out.println ("Press any positive integer to exit the program or 0 to try a new file");
        x = scanner.nextInt();
    }
    }
}
