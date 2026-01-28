package day_28.prms_154538;

import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(x);

        boolean[] visited = new boolean[y * 3];
        visited[x] = true;

        int dist = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int node = q.poll();
                if (node == y) return dist;

                if (node + n <= y && !visited[node + n]) {
                    q.add(node + n);
                    visited[node + n] = true;
                }

                if (node * 2 <= y && !visited[node * 2]) {
                    q.add(node * 2);
                    visited[node * 2] = true;
                }

                if (node * 3 <= y && !visited[node * 3]) {
                    q.add(node * 3);
                    visited[node * 3] = true;
                }
            }

            dist++;
        }

        return -1;
    }
}
