package day_08.boj_20304;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[1 + n];

        st = new StringTokenizer(br.readLine());
        while (m-- > 0) {
            int x = Integer.parseInt(st.nextToken());
            q.offer(x);
            vis[x] = true;
        }

        int dist = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int cur = q.poll();

                for (int i = 0; i < 20; i++) {
                    int nxt = cur ^ (1 << i);
                    if (nxt > n || vis[nxt]) continue;

                    q.offer(nxt);
                    vis[nxt] = true;
                }
            }

            dist++;
        }

        System.out.println(dist - 1);
    }
}
