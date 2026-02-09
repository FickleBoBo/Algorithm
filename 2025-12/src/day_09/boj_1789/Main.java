package day_09.boj_1789;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long s = Long.parseLong(br.readLine());

        long n = 1;
        while (n * (n + 1) / 2 <= s) {
            n++;
        }

        System.out.println(n - 1);
    }
}
