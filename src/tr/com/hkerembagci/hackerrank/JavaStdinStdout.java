package tr.com.hkerembagci.hackerrank;

import java.util.Scanner;

public class JavaStdinStdout {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        double d = Double.parseDouble(scan.next());
        String s = scan.nextLine();
        s += scan.nextLine();

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
        scan.close();
    }
}
