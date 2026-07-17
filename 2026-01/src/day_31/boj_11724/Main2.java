package day_31.boj_11724;

import java.io.*;
import java.util.*;

public class Main2 {

    static List<Integer>[] adj;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[1 + n];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        vis = new boolean[1 + n];
        int cnt = 0;
        for (int node = 1; node <= n; node++) {
            if (vis[node]) continue;

            dfs(node);
            cnt++;
        }

        System.out.println(cnt);
    }

    static void dfs(int cur) {
        vis[cur] = true;

        for (int nxt : adj[cur]) {
            if (vis[nxt]) continue;
            dfs(nxt);
        }
    }
}
