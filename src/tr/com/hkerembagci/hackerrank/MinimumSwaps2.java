package tr.com.hkerembagci.hackerrank;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MinimumSwaps2 {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        /*
            Check the value if it's in the right place or not.
            If the value is in the right place, look at the other one.
            If not, swap it to the right place.
            After swapping, check the new value in the index is correct or not.
            If not correct, swap it too.
            Continue to do these steps.
        */
        int minimumSwaps = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
                i--;
                minimumSwaps++;
            }
        }
        return minimumSwaps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

