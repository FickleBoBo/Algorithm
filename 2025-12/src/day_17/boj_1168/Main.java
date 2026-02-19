package day_17.boj_1168;

import java.io.*;
import java.util.*;

public class Main {

    static int[] tree;

    static void init(int node, int start, int end) {
        if (start == end) {
            tree[node] = 1;
            return;
        }

        int mid = (start + end) / 2;

        init(node * 2, start, mid);
        init(node * 2 + 1, mid + 1, end);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static void update(int node, int start, int end, int idx) {
        if (start == end) {
            tree[node] = 0;
            return;
        }

        int mid = (start + end) / 2;

        if (idx <= mid) {
            update(node * 2, start, mid, idx);
        } else {
            update(node * 2 + 1, mid + 1, end, idx);
        }
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static int queryKth(int node, int start, int end, int k) {
        if (start == end) return start;

        int mid = (start + end) / 2;

        if (k <= tree[node * 2]) {
            return queryKth(node * 2, start, mid, k);
        } else {
            return queryKth(node * 2 + 1, mid + 1, end, k - tree[node * 2]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        tree = new int[4 * n];
        init(1, 1, n);

        int alive = n;
        int cur = 0;

        sb.append("<");
        for (int i = 0; i < n; i++) {
            cur = (cur + k - 1) % alive;

            int idx = queryKth(1, 1, n, cur + 1);
            update(1, 1, n, idx);
            alive--;

            sb.append(idx);
            if (i != n - 1) sb.append(", ");
        }
        sb.append(">");

        System.out.println(sb);
    }
}
