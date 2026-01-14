package day_14.boj_10093;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        if (A > B) {
            long tmp = A;
            A = B;
            B = tmp;
        }

        sb.append(Math.max(B - A - 1, 0)).append("\n");
        for (long i = A + 1; i < B; i++) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}
