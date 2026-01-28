package day_28.boj_1260;

import java.io.*;
import java.util.*;

public class Main {

    static List<Set<Integer>> adj = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            adj.add(new TreeSet<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        boolean[] visited = new boolean[1 + N];
        dfs(V, visited);
        sb.append("\n");
        bfs(V, N);

        System.out.println(sb);
    }

    static void dfs(int node, boolean[] visited) {
        visited[node] = true;
        sb.append(node).append(" ");

        for (int next : adj.get(node)) {
            if (visited[next]) continue;
            dfs(next, visited);
        }
    }

    static void bfs(int start, int N) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        boolean[] visited = new boolean[1 + N];
        visited[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            sb.append(node).append(" ");

            for (int next : adj.get(node)) {
                if (visited[next]) continue;

                q.offer(next);
                visited[next] = true;
            }
        }
    }
}
