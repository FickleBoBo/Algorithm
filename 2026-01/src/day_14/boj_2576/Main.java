package day_14.boj_2576;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int min = 100;

        for (int i = 0; i < 7; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n % 2 == 1) {
                sum += n;
                min = Math.min(min, n);
            }
        }

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
