package day_31.boj_5567;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

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

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);

        boolean[] vis = new boolean[1 + n];
        vis[1] = true;

        int dist = 0;
        int cnt = 0;

        while (!q.isEmpty()) {
            int sz = q.size();

            while (sz-- > 0) {
                int cur = q.poll();

                for (int nxt : adj[cur]) {
                    if (vis[nxt]) continue;

                    q.offer(nxt);
                    vis[nxt] = true;
                    cnt++;
                }
            }

            dist++;
            if (dist == 2) break;
        }

        return cnt;
    }
}
