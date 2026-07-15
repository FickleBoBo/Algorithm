package day_28.prms_154538;

import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(x);

        boolean[] vis = new boolean[y * 3];
        vis[x] = true;

        int dist = 0;

        while (!q.isEmpty()) {
            int sz = q.size();

            while (sz-- > 0) {
                int cur = q.poll();
                if (cur == y) return dist;

                if (cur + n <= y && !vis[cur + n]) {
                    q.offer(cur + n);
                    vis[cur + n] = true;
                }

                if (cur * 2 <= y && !vis[cur * 2]) {
                    q.offer(cur * 2);
                    vis[cur * 2] = true;
                }

                if (cur * 3 <= y && !vis[cur * 3]) {
                    q.offer(cur * 3);
                    vis[cur * 3] = true;
                }
            }

            dist++;
        }

        return -1;
    }
}
