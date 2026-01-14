package day_14.boj_5585;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 1000 - Integer.parseInt(br.readLine());

        int cnt = 0;

        cnt += N / 500;
        N %= 500;

        cnt += N / 100;
        N %= 100;

        cnt += N / 50;
        N %= 50;

        cnt += N / 10;
        N %= 10;

        cnt += N / 5;
        N %= 5;

        cnt += N;

        System.out.println(cnt);
    }
}
