package day_05.boj_12851;

import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] result = bfs(n, k);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    static int[] bfs(int n, int k) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(n);

        int[] dist = new int[1 + MAX];
        Arrays.fill(dist, -1);
        dist[n] = 0;

        int[] ways = new int[1 + MAX];
        ways[n] = 1;

        while (!q.isEmpty()) {
            int node = q.poll();

            int next1 = node - 1;
            if (next1 >= 0) {
                if (dist[next1] == -1) {
                    q.offer(next1);
                    dist[next1] = dist[node] + 1;
                    ways[next1] = ways[node];
                } else if (dist[next1] == dist[node] + 1) {
                    ways[next1] += ways[node];
                }
            }

            int next2 = node + 1;
            if (next2 <= MAX) {
                if (dist[next2] == -1) {
                    q.offer(next2);
                    dist[next2] = dist[node] + 1;
                    ways[next2] = ways[node];
                } else if (dist[next2] == dist[node] + 1) {
                    ways[next2] += ways[node];
                }
            }

            int next3 = node * 2;
            if (next3 <= MAX) {
                if (dist[next3] == -1) {
                    q.offer(next3);
                    dist[next3] = dist[node] + 1;
                    ways[next3] = ways[node];
                } else if (dist[next3] == dist[node] + 1) {
                    ways[next3] += ways[node];
                }
            }
        }

        return new int[]{dist[k], ways[k]};
    }
}
