package day_31.boj_15649;

import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] sel;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sel = new int[M];
        visited = new boolean[1 + N];

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

        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;

            sel[selIdx] = i;
            visited[i] = true;
            dfs(selIdx + 1);
            visited[i] = false;
        }
    }
}
