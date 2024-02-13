import java.util.Arrays;
import java.util.Scanner;

public class _01_RecursiveArraySum {
    public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);
      
        int [] array = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        System.out.println(sumArray(array, 0));
    }

    public static int sumArray(int [] array, int index) {
        if (index >= array.length) {
            return 0;
        }
        return array[index] + sumArray(array, index + 1);
    }
}
