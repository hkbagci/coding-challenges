package tr.com.hkerembagci.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class PlusMinusResult {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        List<Double> resultList = new ArrayList<>();
        resultList.add(0.0);
        resultList.add(0.0);
        resultList.add(0.0);
        for (Integer a : arr) {
            if (a > 0) {
                resultList.set(0, resultList.get(0) + 1);
            } else if (a < 0) {
                resultList.set(1, resultList.get(1) + 1);
            } else {
                resultList.set(2, resultList.get(2) + 1);
            }
        }
        resultList.set(0, resultList.get(0) / (double) arr.size());
        resultList.set(1, resultList.get(1) / arr.size());
        resultList.set(2, resultList.get(2) / arr.size());
        String result = "";
        for (int i = 0; i < resultList.size(); i++) {
            result = String.valueOf(resultList.get(i));
            if (result.length() > 8) {
                result = result.substring(0, 8);
            } else {
                for (int j = result.length(); j < 8; j++) {
                    result += "0";
                }
            }
            System.out.println(result);
        }
    }

}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        PlusMinusResult.plusMinus(arr);

        bufferedReader.close();
    }
}