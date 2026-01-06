package day_06.boj_2476;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int max = 0;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (A == B && B == C) {
                max = Math.max(max, 10000 + A * 1000);
            } else if (A == B) {
                max = Math.max(max, 1000 + A * 100);
            } else if (B == C) {
                max = Math.max(max, 1000 + B * 100);
            } else if (C == A) {
                max = Math.max(max, 1000 + C * 100);
            } else {
                max = Math.max(max, Math.max(A, Math.max(B, C)) * 100);
            }
        }

        System.out.println(max);
    }
}
