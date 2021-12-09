import parser.Parser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

public class LogHandler {
    
    public static void main(String[] args) {

        if (args == null || args.length != 1) {
            System.out.println("Arguments should be in the format --args='<File>'.");
            throw new IllegalArgumentException("Please check the arguments and run again.");
        }

        String file = args[0];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            System.out.println("Parsing file " + file + " for events.");          
            Parser parser = new Parser();          
            parser.parseLogs(reader);          
        } catch (IOException e) {
            System.out.println("Error parsing file < " + file + " >");
            e.printStackTrace();
        }
    }
}
