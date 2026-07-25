package day_13.boj_11403;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] adj;
    static int[][] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        adj = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = new int[n][n];
        for (int i = 0; i < n; i++) {
            bfs(i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(res[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        boolean[] vis = new boolean[n];

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int nxt = 0; nxt < n; nxt++) {
                if (adj[cur][nxt] == 0 || vis[nxt]) continue;
                q.offer(nxt);
                vis[nxt] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (vis[i]) res[start][i] = 1;
        }
    }
}
