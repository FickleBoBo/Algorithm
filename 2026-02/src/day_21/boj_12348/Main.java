package day_21.boj_12348;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int len = s.length();

        long n = Long.parseLong(s);
        for (long i = n - 9 * len; i <= n; i++) {
            long x = i;
            long sum = x;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }

            if (sum == n) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }
}
