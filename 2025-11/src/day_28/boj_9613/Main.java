package day_28.boj_9613;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;  // 오버플로우 주의
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    sum += gcd(arr[i], arr[j]);
                }
            }

            sb.append(sum).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
