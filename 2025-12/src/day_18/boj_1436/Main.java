package day_18.boj_1436;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int n = 666;
        while (true) {
            if (String.valueOf(n).contains("666")) {
                N--;

                if (N == 0) break;
            }
            n++;
        }

        System.out.println(n);
    }
}
