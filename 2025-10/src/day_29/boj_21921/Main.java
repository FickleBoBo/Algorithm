package day_29.boj_21921;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 누적합 배열 계산
        int[] prefixSum = new int[1 + N];
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }

        int max = 0;
        int cnt = 0;
        for (int i = 0; i <= N - X; i++) {
            int diff = prefixSum[i + X] - prefixSum[i];

            if (diff > max) {
                max = diff;
                cnt = 1;
            } else if (diff == max) {
                cnt++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(cnt);
        }
    }
}
