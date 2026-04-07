package day_10.boj_17071;

import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 500000;

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

        boolean[][] vis = new boolean[1 + MAX][2];
        vis[n][0] = true;

        int time = 0;

        while (!q.isEmpty()) {
            int bro = k + time * (time + 1) / 2;
            if (bro > MAX) return -1;

            if (vis[bro][time % 2]) return time;

            int nextParity = (time + 1) % 2;
            int sz = q.size();
            while (sz-- > 0) {
                int cur = q.poll();

                int nxt1 = cur - 1;
                if (nxt1 >= 0 && !vis[nxt1][nextParity]) {
                    q.offer(nxt1);
                    vis[nxt1][nextParity] = true;
                }

                int nxt2 = cur + 1;
                if (nxt2 <= MAX && !vis[nxt2][nextParity]) {
                    q.offer(nxt2);
                    vis[nxt2][nextParity] = true;
                }

                int nxt3 = cur * 2;
                if (nxt3 <= MAX && !vis[nxt3][nextParity]) {
                    q.offer(nxt3);
                    vis[nxt3][nextParity] = true;
                }
            }

            time++;
        }

        return -1;
    }
}
