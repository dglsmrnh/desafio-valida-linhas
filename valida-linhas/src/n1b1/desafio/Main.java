package n1b1.desafio;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)
    {
        //Douglas Marinho - 082190029

        try
        {
            File textFile = new File("prog.txt");
            Scanner fileReader = new Scanner(textFile);
            FileWriter fileWriter = new FileWriter("prog-check.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            Map<Character, Character> closersToOpeners = Map.of(')', '(', ']', '[', '}', '{', '>', '<');

            while(fileReader.hasNextLine())
            {
                String thisLine = fileReader.nextLine();
                Stack<Character> charStack = new Stack<Character>();

                for(Character c : thisLine.toCharArray())
                {
                    boolean isOpener = closersToOpeners.containsValue(c);
                    boolean isCloser = closersToOpeners.containsKey(c);
                    if(isOpener)
                    {
                        charStack.push(c);
                    }
                    else if(isCloser)
                    {
                        Character openerFromCloser = closersToOpeners.get(c);
                        if(!charStack.isEmpty() && charStack.peek() == openerFromCloser)
                        {
                            charStack.pop();
                        }
                        else
                        {
                           charStack.push('E');
                           break;
                        }
                    }
                }

                if(!thisLine.isBlank())
                {
                    if(charStack.isEmpty())
                    {
                        printWriter.println(thisLine + " - OK");
                        System.out.println(thisLine + " - OK");
                    }
                    else
                    {
                        printWriter.println(thisLine + " - invalid");
                        System.out.println(thisLine + " - invalid");
                    }
                }
                else
                {
                    printWriter.println(thisLine);
                    System.out.println(thisLine);
                }
            }

            printWriter.close();
            System.out.println("End of program");
        }
        catch (Exception error)
        {
            System.out.println("ErrorObject => " + error.toString());
            System.out.println("Error => " + error.getMessage());
            System.out.println("Cause => " + error.getCause());
        }
    }
}
