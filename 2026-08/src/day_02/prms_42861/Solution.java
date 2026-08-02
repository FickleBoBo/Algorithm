package day_02.prms_42861;

import java.util.*;

class Solution {

    static int[] p;

    static void make(int n) {
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
    }

    static int find(int x) {
        if (x == p[x]) return x;
        return p[x] = find(p[x]);
    }

    static void union(int x, int y) {
        p[find(y)] = find(x);
    }

    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        make(n);

        int sum = 0;
        int cnt = 0;
        for (int[] cost : costs) {
            int x = cost[0];
            int y = cost[1];
            int v = cost[2];

            if (find(x) == find(y)) continue;

            union(x, y);
            sum += v;
            cnt++;

            if (cnt == n - 1) break;
        }

        return sum;
    }
}
