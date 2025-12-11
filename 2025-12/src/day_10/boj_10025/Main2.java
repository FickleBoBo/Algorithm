package day_10.boj_10025;

import java.io.*;
import java.util.*;

public class Main2 {
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
            maxLen = Math.max(maxLen, input[i][1]);
        }

        // 인덱스에 양동이의 좌표, 값에 양동이의 얼음의 양 저장
        int[] arr = new int[1 + maxLen];
        for (int i = 0; i < N; i++) {
            arr[input[i][1]] = input[i][0];
        }

        // 윈도우의 크기
        int windowSize = 2 * K + 1;

        // 윈도우가 좌표의 최댓값보다 크면 모든 양동이에 닿을 수 있으므로 모든 양동이의 얼음의 합을 출력하고 리턴
        if (windowSize > maxLen) {
            int sum = 0;

            for (int n : arr) {
                sum += n;
            }

            System.out.println(sum);
            return;
        }

        // 초기 윈도우 내 얼음의 합 계산
        int sum = 0;
        for (int i = 0; i < windowSize; i++) {
            sum += arr[i];
        }

        // 윈도우를 이동하며 얼음의 합의 최댓값 계산
        int max = sum;
        for (int i = 0; i <= maxLen - windowSize; i++) {
            sum = sum - arr[i] + arr[i + windowSize];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
