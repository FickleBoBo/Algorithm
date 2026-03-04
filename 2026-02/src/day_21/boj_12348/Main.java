package day_21.boj_12348;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int len = str.length();

        long n = Long.parseLong(str);
        for (long i = n - 9 * len; i <= n; i++) {
            long num = i;
            long sum = num;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            if (sum == n) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }
}
