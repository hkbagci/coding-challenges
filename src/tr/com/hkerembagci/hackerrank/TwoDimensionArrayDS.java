package tr.com.hkerembagci.hackerrank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
        /*
         * Iterate on every 3x3 arrays in arr. Sum the values in every hourglass,
         * return the max value.
         */

        Integer maxHourglassValue = 0;
        for (int i = 0; i <= arr.size() - 3; i++) {
            for (int j = 0; j <= arr.get(i).size() - 3; j++) {
                int tempHourglassValue = arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2);
                tempHourglassValue += arr.get(i + 1).get(j + 1);
                tempHourglassValue += arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2);
                if (null != maxHourglassValue) {
                    if (tempHourglassValue >= 0) {
                        if (tempHourglassValue > maxHourglassValue) {
                            maxHourglassValue = tempHourglassValue;
                        }
                    } else if (tempHourglassValue < 0 && maxHourglassValue < 0) {
                        if (Math.abs(tempHourglassValue) < Math.abs(maxHourglassValue)) {
                            maxHourglassValue = tempHourglassValue;
                        }
                    }
                } else {
                    maxHourglassValue = tempHourglassValue;
                }

            }
        }
        return maxHourglassValue;
    }
}

public class TwoDimensionArrayDS {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

