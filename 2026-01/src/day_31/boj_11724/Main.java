package day_31.boj_11724;

import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] adj;

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

        boolean[] vis = new boolean[1 + n];
        int cnt = 0;
        for (int node = 1; node <= n; node++) {
            if (vis[node]) continue;

            bfs(node, vis);
            cnt++;
        }

        System.out.println(cnt);
    }

    static void bfs(int start, boolean[] vis) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        vis[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int nxt : adj[cur]) {
                if (vis[nxt]) continue;

                q.offer(nxt);
                vis[nxt] = true;
            }
        }
    }
}
