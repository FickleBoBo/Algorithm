package day_05.boj_24479;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static List<Integer>[] adj;
    static boolean[] visited;
    static int[] order;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        adj = new ArrayList[1 + n];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            adj[i].sort(Comparator.naturalOrder());
        }

        visited = new boolean[1 + n];
        order = new int[1 + n];

        dfs(r);

        for (int i = 1; i <= n; i++) {
            sb.append(order[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int node) {
        visited[node] = true;
        order[node] = cnt++;

        for (int next : adj[node]) {
            if (visited[next]) continue;
            dfs(next);
        }
    }
}
