package day_31.boj_5014;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int dist = bfs(f, s, g, u, d);
        if (dist == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(dist);
        }
    }

    static int bfs(int f, int s, int g, int u, int d) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(s);

        boolean[] vis = new boolean[1 + f];
        vis[s] = true;

        int dist = 0;

        while (!q.isEmpty()) {
            int sz = q.size();

            while (sz-- > 0) {
                int cur = q.poll();
                if (cur == g) return dist;

                int up = cur + u;
                if (up <= f && !vis[up]) {
                    q.offer(up);
                    vis[up] = true;
                }

                int down = cur - d;
                if (down >= 1 && !vis[down]) {
                    q.offer(down);
                    vis[down] = true;
                }
            }

            dist++;
        }

        return -1;
    }
}
