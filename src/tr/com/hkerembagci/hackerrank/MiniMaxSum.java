package tr.com.hkerembagci.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class MiniMaxSumResult {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        long min = 0;
        long max = 0;
        long sum = 0;
        for(int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
            if(i == 0 || min > arr.get(i)) {
                min = arr.get(i);
            }
            if(max < arr.get(i)) {
                max = arr.get(i);
            }
        }
        System.out.print((sum - max) + " " + (sum - min));
    }

}

public class MiniMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        MiniMaxSumResult.miniMaxSum(arr);

        bufferedReader.close();
    }
}

