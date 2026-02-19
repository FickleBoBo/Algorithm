package day_17.boj_2243;

import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 1_000_000;

    static int[] tree = new int[4 * MAX];

    static void update(int node, int start, int end, int idx, int delta) {
        if (start == end) {
            tree[node] += delta;
            return;
        }

        int mid = (start + end) / 2;

        if (idx <= mid) {
            update(node * 2, start, mid, idx, delta);
        } else {
            update(node * 2 + 1, mid + 1, end, idx, delta);
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
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 1) {
                int k = queryKth(1, 1, MAX, b);
                sb.append(k).append("\n");
                update(1, 1, MAX, k, -1);
            } else {
                int c = Integer.parseInt(st.nextToken());
                update(1, 1, MAX, b, c);
            }
        }

        System.out.println(sb);
    }
}
