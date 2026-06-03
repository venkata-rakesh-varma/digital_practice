import java.util.Scanner;
public class TypeCasting {
    public static void main(String[] args) {
       
        int myInt = 100;
        double myDouble = myInt; 
        System.out.println("Implicit Casting (Widening): " + myDouble);
        double anotherDouble = 3.14;
        int anotherInt = (int) anotherDouble; 
        System.out.println("Explicit Casting (Narrowing): " + anotherInt);
    }
}
