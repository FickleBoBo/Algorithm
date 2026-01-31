package day_31.boj_11724;

import java.io.*;
import java.util.*;

public class Main2 {

    static List<List<Integer>> adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        visited = new boolean[1 + N];
        int cnt = 0;
        for (int node = 1; node <= N; node++) {
            if (visited[node]) continue;

            dfs(node);
            cnt++;
        }

        System.out.println(cnt);
    }

    static void dfs(int node) {
        visited[node] = true;

        for (int next : adj.get(node)) {
            if (visited[next]) continue;

            dfs(next);
        }
    }
}
