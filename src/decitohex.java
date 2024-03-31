import java.util.Scanner;
import java.util.Stack;

public class decitohex {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int decimal = scanner.nextInt();

        Stack<Character> hexStack = new Stack<>();
        while (decimal != 0) {
            int remainder = decimal % 16;
            char hexDigit;
            if (remainder < 10) {
                hexDigit = (char) (remainder + '0');
            } else {
                hexDigit = (char) (remainder - 10 + 'A');
            }
            hexStack.push(hexDigit);
            decimal /= 16;
        }

        System.out.print("Hexadecimal equivalent: ");
        while (!hexStack.isEmpty()) {
            System.out.print(hexStack.pop());
        }
        scanner.close();
    }
}
