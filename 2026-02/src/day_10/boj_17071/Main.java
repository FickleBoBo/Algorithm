package day_10.boj_17071;

import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 500_000;

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

        boolean[][] visited = new boolean[1 + MAX][2];
        visited[n][0] = true;

        int time = 0;

        while (!q.isEmpty()) {
            int bro = k + time * (time + 1) / 2;
            if (bro > MAX) return -1;

            if (visited[bro][time % 2]) return time;

            int nextParity = (time + 1) % 2;
            int size = q.size();
            while (size-- > 0) {
                int node = q.poll();

                int next1 = node - 1;
                if (next1 >= 0 && !visited[next1][nextParity]) {
                    q.offer(next1);
                    visited[next1][nextParity] = true;
                }

                int next2 = node + 1;
                if (next2 <= MAX && !visited[next2][nextParity]) {
                    q.offer(next2);
                    visited[next2][nextParity] = true;
                }

                int next3 = node * 2;
                if (next3 <= MAX && !visited[next3][nextParity]) {
                    q.offer(next3);
                    visited[next3][nextParity] = true;
                }
            }

            time++;
        }

        return -1;
    }
}
