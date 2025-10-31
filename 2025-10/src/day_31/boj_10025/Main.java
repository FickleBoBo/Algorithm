package day_31.boj_10025;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] input = new int[N][2];  // 양동이의 얼음의 양과 좌표를 임시 저장
        int maxLen = 0;  // 양동이의 좌표의 최댓값
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
            maxLen = Math.max(maxLen, input[i][1]) + 1;
        }

        // 인덱스에 양동이의 좌표, 값에 양동이의 얼음의 양 저장
        int[] arr = new int[maxLen];
        for (int i = 0; i < N; i++) {
            arr[input[i][1]] = input[i][0];
        }

        // 앞에 패딩을 한 칸 준 누적합 배열 계산
        int[] prefixSum = new int[1 + maxLen];
        for (int i = 1; i <= maxLen; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }

        // 닿을 수 있는 범위
        int size = 2 * K + 1;

        // 모든 양동이에 닿을 수 있으면 모든 양동이의 얼음의 양의 합을 출력하고 리턴
        if (size > maxLen) {
            System.out.println(prefixSum[maxLen]);
            return;
        }

        // 누적합 배열에서 구간을 이동하며 최댓값 계산
        int max = 0;
        for (int i = 0; i <= maxLen - size; i++) {
            max = Math.max(max, prefixSum[i + size] - prefixSum[i]);
        }

        System.out.println(max);
    }
}
