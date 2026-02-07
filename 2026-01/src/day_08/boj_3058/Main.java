package day_08.boj_3058;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int sum = 0;
            int min = 100;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 7; i++) {
                int x = Integer.parseInt(st.nextToken());

                if (x % 2 == 0) {
                    sum += x;
                    min = Math.min(min, x);
                }
            }

            sb.append(sum).append(" ").append(min).append("\n");
        }

        System.out.print(sb);
    }
}
