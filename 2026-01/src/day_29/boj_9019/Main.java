package day_29.boj_9019;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(bfs(a, b)).append("\n");
        }

        System.out.print(sb);
    }

    static String bfs(int a, int b) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(a);

        boolean[] vis = new boolean[10000];
        vis[a] = true;

        int[] prv = new int[10000];
        Arrays.fill(prv, -1);
        char[] type = new char[10000];

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == b) {
                StringBuilder sb = new StringBuilder();

                while (prv[cur] != -1) {
                    sb.append(type[cur]);
                    cur = prv[cur];
                }

                return sb.reverse().toString();
            }

            int d1 = cur * 2 % 10000;
            if (!vis[d1]) {
                q.offer(d1);
                vis[d1] = true;
                prv[d1] = cur;
                type[d1] = 'D';
            }

            int d2 = (cur - 1 + 10000) % 10000;
            if (!vis[d2]) {
                q.offer(d2);
                vis[d2] = true;
                prv[d2] = cur;
                type[d2] = 'S';
            }

            int d3 = cur % 1000 * 10 + cur / 1000;
            if (!vis[d3]) {
                q.offer(d3);
                vis[d3] = true;
                prv[d3] = cur;
                type[d3] = 'L';
            }

            int d4 = cur % 10 * 1000 + cur / 10;
            if (!vis[d4]) {
                q.offer(d4);
                vis[d4] = true;
                prv[d4] = cur;
                type[d4] = 'R';
            }
        }

        return null;
    }
}
