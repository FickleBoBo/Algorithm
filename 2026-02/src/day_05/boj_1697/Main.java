package day_05.boj_1697;

import java.io.*;
import java.util.*;

public class Main {

    static final int MX = 100_000;

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

        boolean[] vis = new boolean[1 + MX];
        vis[n] = true;

        int dist = 0;

        while (!q.isEmpty()) {
            int sz = q.size();

            while (sz-- > 0) {
                int cur = q.poll();
                if (cur == k) return dist;

                int nxt1 = cur - 1;
                if (nxt1 >= 0 && !vis[nxt1]) {
                    q.offer(nxt1);
                    vis[nxt1] = true;
                }

                int nxt2 = cur + 1;
                if (nxt2 <= MX && !vis[nxt2]) {
                    q.offer(nxt2);
                    vis[nxt2] = true;
                }

                int nxt3 = cur * 2;
                if (nxt3 <= MX && !vis[nxt3]) {
                    q.offer(nxt3);
                    vis[nxt3] = true;
                }
            }

            dist++;
        }

        return -1;
    }
}
