package day_10.boj_10025;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] input = new int[n][2];  // 양동이의 얼음의 양과 좌표를 임시 저장
        int maxLen = 0;  // 양동이의 좌표의 최댓값
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
            maxLen = Math.max(maxLen, input[i][1]);
        }

        // 인덱스에 양동이의 좌표, 값에 양동이의 얼음의 양 저장
        int[] arr = new int[1 + maxLen];
        for (int i = 0; i < n; i++) {
            arr[input[i][1]] = input[i][0];
        }

        // 누적합 배열 계산
        int[] psum = new int[1 + maxLen];
        psum[0] = arr[0];
        for (int i = 1; i <= maxLen; i++) {
            psum[i] = psum[i - 1] + arr[i];
        }

        // 닿을 수 있는 범위
        int size = 2 * k + 1;

        // 모든 양동이에 닿을 수 있으면 모든 양동이의 얼음의 양의 합을 출력하고 리턴
        if (size > maxLen) {
            System.out.println(psum[maxLen]);
            return;
        }

        // 누적합 배열에서 구간을 이동하며 최댓값 계산
        int max = 0;
        for (int i = 0; i <= maxLen - size; i++) {
            max = Math.max(max, psum[i + size] - psum[i]);
        }

        System.out.println(max);
    }
}
