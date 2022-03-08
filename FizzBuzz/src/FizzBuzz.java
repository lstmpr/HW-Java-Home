import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int num = console.nextInt();
        if (num%3==0 && num%5==0) {
            System.out.println("fizzbuzz");
        }
        else if (num%3==0) {
            System.out.println("fizz");
        }
        else if (num%5==0) {
            System.out.println("buzz");
        }
    }

}
