package day_28.boj_2606;

import java.io.*;
import java.util.*;

public class Main2 {

    static int n;
    static boolean[][] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        adj = new boolean[1 + n][1 + n];
        visited = new boolean[1 + n];

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u][v] = adj[v][u] = true;
        }

        System.out.println(dfs(1) - 1);
    }

    static int dfs(int node) {
        visited[node] = true;
        int cnt = 1;

        for (int next = 1; next <= n; next++) {
            if (!adj[node][next] || visited[next]) continue;
            cnt += dfs(next);
        }

        return cnt;
    }
}
