package day_28.boj_2606;

import java.io.*;
import java.util.*;

public class Main2 {

    static int n;
    static boolean[][] adj;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        adj = new boolean[1 + n][1 + n];
        vis = new boolean[1 + n];

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u][v] = adj[v][u] = true;
        }

        System.out.println(dfs(1) - 1);
    }

    static int dfs(int cur) {
        vis[cur] = true;
        int cnt = 1;

        for (int nxt = 1; nxt <= n; nxt++) {
            if (!adj[cur][nxt] || vis[nxt]) continue;
            cnt += dfs(nxt);
        }

        return cnt;
    }
}
