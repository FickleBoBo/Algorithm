package day_28.boj_2559;

import java.io.*;
import java.util.*;

public class Main {
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

        // 누적합 배열 초기화
        int[] prefixSum = new int[1 + N];
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }

        // 누적합의 차로 구간합 계산 및 최댓값 갱신
        int max = Integer.MIN_VALUE;
        for (int i = K; i <= N; i++) {
            max = Math.max(max, prefixSum[i] - prefixSum[i - K]);
        }

        System.out.println(max);
    }
}
