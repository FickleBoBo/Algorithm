package day_14.prms_154538;

import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = bfs(x, y, n);
        return answer;
    }

    private static int bfs(int x, int y, int n) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(x);

        Set<Integer> visited = new HashSet<>();
        visited.add(x);

        int dist = 0;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int node = q.poll();
                if (node == y) return dist;

                if (node + n <= y && !visited.contains(node + n)) {
                    q.add(node + n);
                    visited.add(node + n);
                }

                if (node * 2 <= y && !visited.contains(node * 2)) {
                    q.add(node * 2);
                    visited.add(node * 2);
                }

                if (node * 3 <= y && !visited.contains(node * 3)) {
                    q.add(node * 3);
                    visited.add(node * 3);
                }
            }

            dist++;
        }

        return -1;
    }
}
