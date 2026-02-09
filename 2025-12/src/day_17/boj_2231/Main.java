package day_17.boj_2231;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            int num = i;
            int sum = num;
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
