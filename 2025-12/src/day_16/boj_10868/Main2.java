package day_16.boj_10868;

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

        int[][] sp = new int[LOG][N];
        System.arraycopy(arr, 0, sp[0], 0, N);

        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i + (1 << k) <= N; i++) {
                sp[k][i] = Math.min(sp[k - 1][i], sp[k - 1][i + (1 << (k - 1))]);
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            int k = lg[b - a + 1];
            sb.append(Math.min(sp[k][a], sp[k][b - (1 << k) + 1])).append("\n");
        }

        System.out.println(sb);
    }
}
