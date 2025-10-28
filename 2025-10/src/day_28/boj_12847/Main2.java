package day_28.boj_12847;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 초기 윈도우의 합 계산
        long sum = 0;
        for (int i = 0; i < M; i++) {
            sum += arr[i];
        }

        // 윈도우를 이동시키며 최대 이익 계산
        long max = sum;
        for (int i = 0; i < N - M; i++) {
            sum = sum - arr[i] + arr[i + M];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
