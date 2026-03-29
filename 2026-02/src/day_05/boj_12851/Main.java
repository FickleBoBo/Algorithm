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

        int[] res = bfs(n, k);
        System.out.println(res[0]);
        System.out.println(res[1]);
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
            int cur = q.poll();

            int nxt1 = cur - 1;
            if (nxt1 >= 0) {
                if (dist[nxt1] == -1) {
                    q.offer(nxt1);
                    dist[nxt1] = dist[cur] + 1;
                    ways[nxt1] = ways[cur];
                } else if (dist[nxt1] == dist[cur] + 1) {
                    ways[nxt1] += ways[cur];
                }
            }

            int nxt2 = cur + 1;
            if (nxt2 <= MAX) {
                if (dist[nxt2] == -1) {
                    q.offer(nxt2);
                    dist[nxt2] = dist[cur] + 1;
                    ways[nxt2] = ways[cur];
                } else if (dist[nxt2] == dist[cur] + 1) {
                    ways[nxt2] += ways[cur];
                }
            }

            int nxt3 = cur * 2;
            if (nxt3 <= MAX) {
                if (dist[nxt3] == -1) {
                    q.offer(nxt3);
                    dist[nxt3] = dist[cur] + 1;
                    ways[nxt3] = ways[cur];
                } else if (dist[nxt3] == dist[cur] + 1) {
                    ways[nxt3] += ways[cur];
                }
            }
        }

        return new int[]{dist[k], ways[k]};
    }
}
