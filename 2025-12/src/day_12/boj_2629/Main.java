package day_12.boj_2629;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] warr = new int[1 + n];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sum += warr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        int[] beads = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            beads[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[1 + n][1 + sum];
        dp[0][0] = true;  // 추가 주어지지 않아도 구슬의 무게가 0이면 측정 가능
        for (int i = 1; i <= n; i++) {
            int w = warr[i];

            for (int j = 0; j <= sum; j++) {
                if (!dp[i - 1][j]) continue;

                dp[i][j] = true;  // 현재 추를 사용하지 않는 경우
                dp[i][j + w] = true;  // 현재 추를 사용하는 경우
                dp[i][Math.abs(j - w)] = true;  // 현재 추를 사용하는 경우
            }
        }

        for (int bead : beads) {
            // 구슬의 무게가 모든 추의 무게보다 크거나 추의 조합으로 측정 불가능하면 N
            if (bead > sum || !dp[n][bead]) {
                sb.append("N ");
            } else {
                sb.append("Y ");
            }
        }

        System.out.println(sb);
    }
}
