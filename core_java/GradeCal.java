import java.util.Scanner;
public class GradeCal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter marks for Subject 1: ");
        double subject1 = scanner.nextDouble();
        System.out.print("Enter marks for Subject 2: ");
        double subject2 = scanner.nextDouble();
        System.out.print("Enter marks for Subject 3: ");
        double subject3 = scanner.nextDouble();
        double totalMarks = subject1 + subject2 + subject3;
        double percentage = (totalMarks / 300) * 100;
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Percentage: " + percentage + "%");
        if (percentage >= 90) {
            System.out.println("Grade: A");
        } else if (percentage >= 80) {
            System.out.println("Grade: B");
        } else if (percentage >= 70) {
            System.out.println("Grade: C");
        } else if (percentage >= 60) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }
        scanner.close();
        
    }
}
