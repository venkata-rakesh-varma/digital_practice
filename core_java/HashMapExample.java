import java.util.HashMap;
import java.util.Scanner;

public class HashMapExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> studentMap = new HashMap<>();
        
        System.out.println("Enter student IDs and Names (type '-1' for ID to stop adding):");
        while (true) {
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            if (id == -1) {
                break;
            }
            
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            
            studentMap.put(id, name);
        }
        
        System.out.println("\nAll entries added.");
        System.out.print("Enter an ID to search for a student: ");
        int searchId = scanner.nextInt();
        
        // Retrieve and display based on ID
        if (studentMap.containsKey(searchId)) {
            System.out.println("Student Name: " + studentMap.get(searchId));
        } else {
            System.out.println("Student ID not found.");
        }
        
        scanner.close();
    }
}