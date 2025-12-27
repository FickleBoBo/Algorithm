package day_12.boj_1106;

import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] costs = new int[1 + N];
        int[] people = new int[1 + N];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            costs[i] = Integer.parseInt(st.nextToken());
            people[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[1 + N][1 + C + 100];
        Arrays.fill(dp[0], 1, dp[0].length, MAX);
        for (int i = 1; i <= N; i++) {
            int cost = costs[i];
            int person = people[i];

            for (int j = 1; j <= C + 100; j++) {
                if (j < person) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j - person] + cost, dp[i - 1][j]);
                }
            }
        }

        int min = MAX;
        for (int j = C; j <= C + 100; j++) {
            min = Math.min(min, dp[N][j]);
        }

        System.out.println(min);
    }
}
