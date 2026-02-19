package day_09.boj_2559;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] psum = new int[1 + n];
        for (int i = 1; i <= n; i++) {
            psum[i] = psum[i - 1] + arr[i - 1];
        }

        // 누적합의 차로 구간합 계산 및 최댓값 갱신
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= n - k; i++) {
            max = Math.max(max, psum[i + k] - psum[i]);
        }

        System.out.println(max);
    }
}
