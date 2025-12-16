package day_16.boj_2357;

import java.io.*;
import java.util.*;

public class Main2 {

    static final int LOG = 20;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] lg = new int[1 + N];
        for (int i = 2; i <= N; i++) {
            lg[i] = lg[i / 2] + 1;
        }

        int[][] stMin = new int[LOG][N];
        int[][] stMax = new int[LOG][N];
        System.arraycopy(arr, 0, stMin[0], 0, N);
        System.arraycopy(arr, 0, stMax[0], 0, N);

        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i + (1 << k) <= N; i++) {
                stMin[k][i] = Math.min(stMin[k - 1][i], stMin[k - 1][i + (1 << (k - 1))]);
                stMax[k][i] = Math.max(stMax[k - 1][i], stMax[k - 1][i + (1 << (k - 1))]);
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            int k = lg[b - a + 1];
            sb.append(Math.min(stMin[k][a], stMin[k][b - (1 << k) + 1])).append(" ")
                    .append(Math.max(stMax[k][a], stMax[k][b - (1 << k) + 1])).append("\n");
        }

        System.out.println(sb);
    }
}
