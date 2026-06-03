import java.util.Random;
import java.util.Scanner;
public class GuessNumber {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner s = new Scanner(System.in);
        int targetNumber = random.nextInt(100) + 1;
        int guess;
        do {
            System.out.print("Enter your guess (1-100): ");
            guess = s.nextInt();
            if (guess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > targetNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number.");
            }
        } while (guess != targetNumber);
    }
}
