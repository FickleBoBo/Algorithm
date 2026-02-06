package day_03.boj_2444;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int left = n;
        int right = n;
        for (int i = 1; i <= 2 * n - 1; i++) {
            for (int j = 1; j < left; j++) {
                sb.append(" ");
            }
            for (int j = left; j <= right; j++) {
                sb.append("*");
            }
            sb.append("\n");

            if (i < n) {
                left--;
                right++;
            } else {
                left++;
                right--;
            }
        }

        System.out.println(sb);
    }
}
