//Tye Borden
//TextChecker.java

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class is used to check and see if text documents (txt files)
 * contain certain words and on what lines those words are contained. The
 * file being searched should be in the same directory as the java file to
 * work correctly.
 * @author Tye Borden
 */
public class TextChecker
{

    public static void main(String[] args)
    {
        //The scanner object for the keyboard input
        Scanner kbd = new Scanner(System.in);
        System.out.print("What file would you like to read first ?: ");
        String file = kbd.nextLine();
        System.out.println();

        //The Scanner object for the file object that is being read in.
        Scanner input = null;

        //This while loop until a proper file name is given.
        while (input == null)
        {
            //Try catch for checking if the file exists.
            try
            {
                input = new Scanner(new File(file));
            }
            catch (FileNotFoundException e)
            {
                System.out.println("This file does not exist!!!");
                System.out.print("What file would you like to read"
                    + " first ?: ");
                file = kbd.nextLine();
                System.out.println();
            }
        }

        //Notification to the user the file has been found.
        System.out.println("The file has been found!");

        /*
        This is the Two dementional Array List the text file is put into.
         */
        ArrayList<ArrayList<String>> txtFile
            = new ArrayList<ArrayList<String>>();

        //The loop to put the text document in an Array List
        while (input.hasNextLine())
        {
            String line = input.nextLine();
            String[] lineSplit = line.split(" ");
            txtFile.add(new ArrayList<>(Arrays.asList(lineSplit)));

        }

        //This prints out to that the file is in the Array List.
        for (int i = 0; i < txtFile.size(); i++)
        {
            System.out.println(txtFile.get(i));
        }

        //The prompt asking for what word the user is looking for.
        System.out.print("What word are you looking for ?"
            + "(Enter -1 to quit): ");
        String word = kbd.next().toLowerCase();
        kbd.nextLine();

        //Repeats asking for words to search until the user enters -1.
        while (!word.equals("-1"))
        {
            ArrayList<Integer> lines = new ArrayList<>();
            int count = 1;
            for (int j = 0; j < txtFile.size(); j++)
            {
                for (int i = 0; i < txtFile.get(j).size(); i++)
                {
                    if (txtFile.get(j).get(i)
                        .toLowerCase()
                        .contains(word))
                    {
                        lines.add(count);
                    }
                }
                count++;
            }

            if (lines.size() == 0)
            {
                System.out.println("It apperead on no lines!");
            }

            else
            {
                System.out.println(word + " appears on lines: ");

                for (int i = 0; i < lines.size(); i++)
                {
                    System.out.println("Line " + lines.get(i));
                }
            }
            System.out.print("What word are you looking for ?"
                + "(Enter -1 to quit): ");
            word = kbd.next().toLowerCase();
            kbd.nextLine();
        }
    }
}
