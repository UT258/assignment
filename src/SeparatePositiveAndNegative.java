import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class SeparatePositiveAndNegative {
     public static void main(String[] args) {
        Queue<Integer> positiveQueue = new LinkedList<>();
        Queue<Integer> negativeQueue = new LinkedList<>();

        // Read integer values from the file
        try {
            Scanner scanner = new Scanner(new File("src/data_file.txt"));
            while (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                if (num < 0) {
                    negativeQueue.offer(num);
                } else {
                    positiveQueue.offer(num);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
            e.printStackTrace();
            return;
        }

        // Display positive values
        System.out.println("Positive Values:");
        while (!positiveQueue.isEmpty()) {
            System.out.println(positiveQueue.poll());
        }

        // Display negative values
        System.out.println("Negative Values:");
        while (!negativeQueue.isEmpty()) {
            System.out.println(negativeQueue.poll());
        }
    }
}
