package day_12.boj_1106;

import java.io.*;
import java.util.*;

public class Main2 {

    private static final int MAX = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] costs = new int[N];
        int[] people = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            costs[i] = Integer.parseInt(st.nextToken());
            people[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[1 + C + 100];
        Arrays.fill(dp, 1, dp.length, MAX);

        for (int i = 0; i < N; i++) {
            int cost = costs[i];
            int person = people[i];

            for (int j = person; j <= C + 100; j++) {
                dp[j] = Math.min(dp[j - person] + cost, dp[j]);
            }
        }

        int min = MAX;
        for (int j = C; j <= C + 100; j++) {
            min = Math.min(min, dp[j]);
        }

        System.out.println(min);
    }
}
