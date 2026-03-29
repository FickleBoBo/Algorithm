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

        boolean[][] vis = new boolean[1 + MAX][1 + MAX];
        vis[1][0] = true;

        int dist = 0;

        while (!q.isEmpty()) {
            int sz = q.size();

            while (sz-- > 0) {
                int[] cur = q.poll();
                if (cur[0] == s) return dist;

                if (!vis[cur[0]][cur[0]]) {
                    q.offer(new int[]{cur[0], cur[0]});
                    vis[cur[0]][cur[0]] = true;
                }

                if (cur[0] + cur[1] <= MAX && !vis[cur[0] + cur[1]][cur[1]]) {
                    q.offer(new int[]{cur[0] + cur[1], cur[1]});
                    vis[cur[0] + cur[1]][cur[1]] = true;
                }

                if (cur[0] > 0 && !vis[cur[0] - 1][cur[1]]) {
                    q.offer(new int[]{cur[0] - 1, cur[1]});
                    vis[cur[0] - 1][cur[1]] = true;
                }
            }

            dist++;
        }

        return -1;
    }
}
