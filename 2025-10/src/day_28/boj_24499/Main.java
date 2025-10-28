package day_28.boj_24499;

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

        // 초기 윈도우의 합 계산
        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }

        // 원형으로 윈도우 이동 및 최댓값 갱신
        int max = sum;
        for (int i = 0; i < N; i++) {
            sum = sum - arr[i] + arr[(i + K) % N];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
