import java.util.Scanner;
public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the position in Fibonacci sequence: ");
        int n = scanner.nextInt();
        long result = fibonacci(n);
        System.out.println("Fibonacci number at position " + n + " is: " + result);
        scanner.close();
    }

    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
}
