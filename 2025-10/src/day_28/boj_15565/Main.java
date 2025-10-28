package day_28.boj_15565;

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

        // 투 포인터 알고리즘
        int left = 0;
        int right = 0;
        int cnt = 0;  // 구간 내 라이언 인형의 개수
        int min = Integer.MAX_VALUE;  // 조건을 만족하는 구간의 길이의 최솟값

        while (true) {
            if (cnt < K) {
                if (arr[right++] == 1) cnt++;
            } else {
                if (cnt == K) {
                    min = Math.min(min, right - left);
                }

                if (arr[left++] == 1) cnt--;
            }

            if (right == arr.length && cnt < K) break;
        }

        // 갱신된 적 없으면 -1을 출력
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
