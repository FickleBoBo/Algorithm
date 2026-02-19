package day_09.boj_2559;

import java.io.*;
import java.util.*;

public class Main2 {
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

        // 초기 윈도우의 합 계산
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        // 윈도우를 이동하며 최댓값 반복 갱신
        int max = sum;
        for (int i = 0; i < n - k; i++) {
            sum = sum - arr[i] + arr[i + k];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
