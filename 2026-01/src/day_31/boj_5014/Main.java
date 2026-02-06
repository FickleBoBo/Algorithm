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

        boolean[] visited = new boolean[1 + f];
        visited[s] = true;

        int dist = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int node = q.poll();
                if (node == g) return dist;

                int up = node + u;
                if (up <= f && !visited[up]) {
                    q.offer(up);
                    visited[up] = true;
                }

                int down = node - d;
                if (down >= 1 && !visited[down]) {
                    q.offer(down);
                    visited[down] = true;
                }
            }

            dist++;
        }

        return -1;
    }
}
