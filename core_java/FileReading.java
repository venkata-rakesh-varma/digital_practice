import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReading {
    public static void main(String[] args) {
        try {
            File file = new File("output.txt");
            Scanner fileScanner = new Scanner(file);
            
            System.out.println("Contents of output.txt:");
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: output.txt was not found. Please run FileWriting.java first.");
            e.printStackTrace();
        }
    }
}