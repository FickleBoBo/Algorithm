package day_08.boj_2839;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N >= 0 && N % 5 == 0) {
            System.out.println(N / 5);
        } else if (N >= 3 && (N - 3) % 5 == 0) {
            System.out.println((N - 3) / 5 + 1);
        } else if (N >= 6 && (N - 6) % 5 == 0) {
            System.out.println((N - 6) / 5 + 2);
        } else if (N >= 9 && (N - 9) % 5 == 0) {
            System.out.println((N - 9) / 5 + 3);
        } else if (N >= 12 && (N - 12) % 5 == 0) {
            System.out.println((N - 12) / 5 + 4);
        } else {
            System.out.println(-1);
        }
    }
}
