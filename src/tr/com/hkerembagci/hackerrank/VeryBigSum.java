package tr.com.hkerembagci.hackerrank;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class VeryBigSumResult {

    /*
     * Complete the 'aVeryBigSum' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER_ARRAY ar as parameter.
     */

    public static long aVeryBigSum(List<Long> ar) {
        long sum = 0L;
        return ar.stream().map((a) -> a).reduce(sum, (accumulator, _item) -> accumulator + _item);
    }

}

public class VeryBigSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int arCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Long> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long veryBigSumResult = VeryBigSumResult.aVeryBigSum(ar);

        bufferedWriter.write(String.valueOf(veryBigSumResult));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
