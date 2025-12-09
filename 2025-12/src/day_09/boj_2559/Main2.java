package day_09.boj_2559;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 초기 윈도우의 합 계산
        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }

        // 윈도우를 이동하며 최댓값 반복 갱신
        int max = sum;
        for (int i = 0; i < N - K; i++) {
            sum = sum - arr[i] + arr[i + K];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
