package day_01.boj_10162;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int A = T / 300;
        T %= 300;

        int B = T / 60;
        T %= 60;

        int C = T / 10;
        T %= 10;

        if (T == 0) {
            System.out.println(A + " " + B + " " + C);
        } else {
            System.out.println(-1);
        }
    }
}
