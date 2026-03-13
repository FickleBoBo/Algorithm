package day_31.boj_2644;

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

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u][v] = adj[v][u] = true;
        }

        System.out.println(bfs(x, y));
    }

    static int bfs(int x, int y) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(x);

        boolean[] vis = new boolean[1 + n];
        vis[x] = true;

        int dist = 0;

        while (!q.isEmpty()) {
            int sz = q.size();

            while (sz-- > 0) {
                int cur = q.poll();
                if (cur == y) return dist;

                for (int nxt = 1; nxt <= n; nxt++) {
                    if (!adj[cur][nxt] || vis[nxt]) continue;

                    q.offer(nxt);
                    vis[nxt] = true;
                }
            }

            dist++;
        }

        return -1;
    }
}
