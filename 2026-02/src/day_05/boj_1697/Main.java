package day_05.boj_1697;

import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(bfs(n, k));
    }

    static int bfs(int n, int k) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(n);

        boolean[] visited = new boolean[1 + MAX];
        visited[n] = true;

        int dist = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int node = q.poll();
                if (node == k) return dist;

                int next1 = node - 1;
                if (next1 >= 0 && !visited[next1]) {
                    q.offer(next1);
                    visited[next1] = true;
                }

                int next2 = node + 1;
                if (next2 <= MAX && !visited[next2]) {
                    q.offer(next2);
                    visited[next2] = true;
                }

                int next3 = node * 2;
                if (next3 <= MAX && !visited[next3]) {
                    q.offer(next3);
                    visited[next3] = true;
                }
            }

            dist++;
        }

        return -1;
    }
}
