package day_28.boj_2606;

import java.io.*;
import java.util.*;

public class Main2 {

    static int N;
    static boolean[][] adj;
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        adj = new boolean[1 + N][1 + N];

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x][y] = adj[y][x] = true;
        }

        visited = new boolean[1 + N];
        dfs(1);

        System.out.println(cnt - 1);
    }

    static void dfs(int node) {
        visited[node] = true;
        cnt++;

        for (int next = 1; next <= N; next++) {
            if (adj[node][next] && !visited[next]) {
                dfs(next);
            }
        }
    }
}
