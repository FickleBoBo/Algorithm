package day_01.prms_154538;

import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(x);

        int[] dist = new int[1 + y];
        Arrays.fill(dist, -1);
        dist[x] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == y) return dist[cur];

            if (cur + n <= y && dist[cur + n] == -1) {
                q.offer(cur + n);
                dist[cur + n] = dist[cur] + 1;
            }

            if (cur * 2 <= y && dist[cur * 2] == -1) {
                q.offer(cur * 2);
                dist[cur * 2] = dist[cur] + 1;
            }

            if (cur * 3 <= y && dist[cur * 3] == -1) {
                q.offer(cur * 3);
                dist[cur * 3] = dist[cur] + 1;
            }
        }

        return -1;
    }
}
