package tr.com.hkerembagci.hackerrank;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ArrayManipulation {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : queries) {
            Integer leftIndex = list.get(0);
            Integer rightIndex = list.get(1);
            Integer summand = list.get(2);

            map.put(leftIndex, (map.containsKey(leftIndex) ? map.get(leftIndex) : 0) + summand);
            map.put(rightIndex + 1, (map.containsKey(rightIndex + 1) ? map.get(rightIndex + 1) : 0) - summand);
        }

        int maxValue = 0;
        int sum = 0;
        for (int j = 0; j < n; j++) {
            sum += (map.containsKey(j + 1) ? map.get(j + 1) : 0);
            maxValue = Math.max(maxValue, sum);
        }

        return maxValue;
    }
}
