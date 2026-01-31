package day_31.boj_15663;

import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] arr;
    static int[] sel;
    static boolean[] visited;

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
        visited = new boolean[N];

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
            if (visited[i]) continue;
            if (arr[i] == prev) continue;

            prev = sel[selIdx] = arr[i];
            visited[i] = true;
            dfs(selIdx + 1);
            visited[i] = false;
        }
    }
}
