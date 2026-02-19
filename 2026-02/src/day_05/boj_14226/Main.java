package day_05.boj_14226;

import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int s = Integer.parseInt(br.readLine());
        System.out.println(bfs(s));
    }

    static int bfs(int s) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1, 0});

        boolean[][] visited = new boolean[1 + MAX][1 + MAX];
        visited[1][0] = true;

        int dist = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] node = q.poll();
                if (node[0] == s) return dist;

                if (!visited[node[0]][node[0]]) {
                    q.offer(new int[]{node[0], node[0]});
                    visited[node[0]][node[0]] = true;
                }

                if (node[0] + node[1] <= MAX && !visited[node[0] + node[1]][node[1]]) {
                    q.offer(new int[]{node[0] + node[1], node[1]});
                    visited[node[0] + node[1]][node[1]] = true;
                }

                if (node[0] > 0 && !visited[node[0] - 1][node[1]]) {
                    q.offer(new int[]{node[0] - 1, node[1]});
                    visited[node[0] - 1][node[1]] = true;
                }
            }

            dist++;
        }

        return -1;
    }
}
