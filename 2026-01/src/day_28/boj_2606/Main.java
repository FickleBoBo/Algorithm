package day_28.boj_2606;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static boolean[][] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        adj = new boolean[1 + n][1 + n];

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u][v] = adj[v][u] = true;
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);

        boolean[] vis = new boolean[1 + n];
        vis[1] = true;

        int cnt = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int nxt = 1; nxt <= n; nxt++) {
                if (!adj[cur][nxt] || vis[nxt]) continue;

                q.offer(nxt);
                vis[nxt] = true;
                cnt++;
            }
        }

        return cnt;
    }
}
