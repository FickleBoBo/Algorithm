package day_06.boj_8958;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), "X");

            int sum = 0;
            while (st.hasMoreTokens()) {
                int x = st.nextToken().length();
                sum += x * (x + 1) / 2;
            }

            sb.append(sum).append("\n");
        }

        System.out.print(sb);
    }
}
