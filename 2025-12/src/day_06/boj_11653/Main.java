package day_06.boj_11653;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int div = 2;

        while (n > 1) {
            while (n % div == 0) {
                n /= div;
                sb.append(div).append("\n");
            }

            div++;
        }

        System.out.println(sb);
    }
}
