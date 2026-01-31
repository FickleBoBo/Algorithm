package day_31.boj_15665;

import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] arr;
    static int[] sel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        sel = new int[M];

        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int selIdx) {
        if (selIdx == M) {
            for (int x : sel) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == prev) continue;

            prev = sel[selIdx] = arr[i];
            dfs(selIdx + 1);
        }
    }
}
