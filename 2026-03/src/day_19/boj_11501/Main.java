package day_19.boj_11501;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long ans = 0;
            int max = 0;
            for (int i = n - 1; i >= 0; i--) {
                max = Math.max(max, arr[i]);
                ans += max - arr[i];
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}
