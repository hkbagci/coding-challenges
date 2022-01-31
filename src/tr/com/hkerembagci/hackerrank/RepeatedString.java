package tr.com.hkerembagci.hackerrank;

import java.io.*;

class RepeatedStringResult {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {
        long count = 0;
        for(char c : s.toCharArray()) {
            if(c == 'a') {
                count++;
            }
        }
        count *= n / s.length();
        for(int i = 0; i < n % s.length(); i++) {
            if(s.charAt(i) == 'a') {
                count++;
            }
        }
        return count;
    }

}

public class RepeatedString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = RepeatedStringResult.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

