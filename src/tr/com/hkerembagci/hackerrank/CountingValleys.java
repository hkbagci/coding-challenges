package tr.com.hkerembagci.hackerrank;

import java.io.*;

class CountingValleysResult {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        int valleyCount = 0;
        int altitude = 0;
        for (char c : path.toCharArray()) {
            if (c == 'U') {
                altitude++;
                if (altitude == 0) {
                    valleyCount++;
                }
            } else {
                altitude--;
            }
        }
        return valleyCount;
    }

}

public class CountingValleys {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = CountingValleysResult.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}