package day_28.boj_1260;

import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] adj;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

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
        for (int i = 1; i <= n; i++) {
            adj[i].sort(Comparator.naturalOrder());
        }

        vis = new boolean[1 + n];
        dfs(k);

        sb.append("\n");

        vis = new boolean[1 + n];
        bfs(k);

        System.out.println(sb);
    }

    static void dfs(int cur) {
        vis[cur] = true;
        sb.append(cur).append(" ");

        for (int nxt : adj[cur]) {
            if (vis[nxt]) continue;
            dfs(nxt);
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        vis[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");

            for (int nxt : adj[cur]) {
                if (vis[nxt]) continue;

                q.offer(nxt);
                vis[nxt] = true;
            }
        }
    }
}
