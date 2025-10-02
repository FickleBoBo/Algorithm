package day_03.prms_42861;

import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        // 크루스칼 알고리즘을 위해 간선 배열을 오름차순으로 정렬
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        // union-find 알고리즘을 위한 make set
        make(n);

        return kruskal(n, costs);
    }

    // union-find 부모 배열
    private static int[] p;

    // make set
    private static void make(int n) {
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
    }

    // find set
    private static int find(int x) {
        if (x == p[x]) return x;
        return p[x] = find(p[x]);
    }

    // union set
    private static void union(int x, int y) {
        p[find(y)] = find(x);
    }

    private static int kruskal(int n, int[][] edges) {
        int sum = 0;
        int cnt = 0;

        for (int[] edge : edges) {
            if (find(edge[0]) == find(edge[1])) continue;

            union(edge[0], edge[1]);
            sum += edge[2];
            cnt++;

            // n개의 정점에 대해 n - 1개의 간선을 선택하면 최소 스패닝 트리 완성
            if (cnt == n - 1) break;
        }

        return sum;
    }
}
