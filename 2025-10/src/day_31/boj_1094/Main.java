package day_31.boj_1094;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int cnt = 0;

        while (X > 0) {
            if (X % 2 == 1) {
                cnt++;
            }

            X /= 2;
        }

        System.out.println(cnt);
    }
}
