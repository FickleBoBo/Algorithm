package day_29.prms_118669;

import java.util.*;

class Solution {

    static int INF = 10_000_001;

    static class Node implements Comparable<Node> {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<Node>[] adj = new ArrayList[1 + n];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] path : paths) {
            adj[path[0]].add(new Node(path[1], path[2]));
            adj[path[1]].add(new Node(path[0], path[2]));
        }

        boolean[] isGate = new boolean[1 + n];
        boolean[] isSummit = new boolean[1 + n];
        for (int gate : gates) {
            isGate[gate] = true;
        }
        for (int summit : summits) {
            isSummit[summit] = true;
        }

        return dijkstra(gates, n, adj, isGate, isSummit);
    }

    static int[] dijkstra(int[] gates, int n, List<Node>[] adj, boolean[] isGate, boolean[] isSummit) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int gate : gates) {
            pq.offer(new Node(gate, 0));
        }

        boolean[] vis = new boolean[1 + n];

        int[] ans = new int[]{0, INF};

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (isSummit[cur.v]) {
                if (cur.w < ans[1] || cur.w == ans[1] && cur.v < ans[0]) {
                    ans[0] = cur.v;
                    ans[1] = cur.w;
                }
                continue;
            }

            if (vis[cur.v]) continue;
            vis[cur.v] = true;

            for (Node nxt : adj[cur.v]) {
                if (isGate[nxt.v] || vis[nxt.v]) continue;
                pq.offer(new Node(nxt.v, Math.max(cur.w, nxt.w)));
            }
        }

        return ans;
    }
}
