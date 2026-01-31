package day_31.boj_5014;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int result = bfs(F, S, G, U, D);
        if (result == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(result);
        }
    }

    static int bfs(int F, int S, int G, int U, int D) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(S);

        boolean[] visited = new boolean[1 + F];
        visited[S] = true;

        int dist = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int node = q.poll();
                if (node == G) return dist;

                int up = node + U;
                if (up <= F && !visited[up]) {
                    q.offer(up);
                    visited[up] = true;
                }

                int down = node - D;
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
