import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> students = new ArrayList<>();
        
        System.out.println("Enter student names (type 'done' to stop):");
        while (true) {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            
            if (name.equalsIgnoreCase("done")) {
                break;
            }
            
            students.add(name);
        }
        
        System.out.println("\n--- List of Students ---");
        for (String student : students) {
            System.out.println(student);
        }
        
        scanner.close();
    }
}