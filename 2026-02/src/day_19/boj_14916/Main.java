package day_19.boj_14916;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n % 5 == 0) {
            System.out.println(n / 5);
        } else if (n >= 2 && (n - 2) % 5 == 0) {
            System.out.println((n - 2) / 5 + 1);
        } else if (n >= 4 && (n - 4) % 5 == 0) {
            System.out.println((n - 4) / 5 + 2);
        } else if (n >= 6 && (n - 6) % 5 == 0) {
            System.out.println((n - 6) / 5 + 3);
        } else if (n >= 8 && (n - 8) % 5 == 0) {
            System.out.println((n - 8) / 5 + 4);
        } else {
            System.out.println(-1);
        }
    }
}
