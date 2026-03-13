package day_31.boj_16953;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(bfs(a, b));
    }

    static int bfs(int a, int b) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(a);

        Set<Integer> vis = new HashSet<>();
        vis.add(a);

        int dist = 1;

        while (!q.isEmpty()) {
            int sz = q.size();

            while (sz-- > 0) {
                int cur = q.poll();
                if (cur == b) return dist;

                if (cur * 2L <= b && !vis.contains(cur * 2)) {
                    q.offer(cur * 2);
                    vis.add(cur * 2);
                }

                if (cur * 10L + 1 <= b && !vis.contains(cur * 10 + 1)) {
                    q.offer(cur * 10 + 1);
                    vis.add(cur * 10 + 1);
                }
            }

            dist++;
        }

        return -1;
    }
}
