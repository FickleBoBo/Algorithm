package day_17.boj_14428;

import java.io.*;
import java.util.*;

public class Main2 {

    static int[] arr;
    static int[] tree;

    static void init(int node, int start, int end) {
        if (start == end) {
            tree[node] = start;
            return;
        }

        int mid = (start + end) / 2;

        init(node * 2, start, mid);
        init(node * 2 + 1, mid + 1, end);

        if (arr[tree[node * 2]] <= arr[tree[node * 2 + 1]]) {
            tree[node] = tree[node * 2];
        } else {
            tree[node] = tree[node * 2 + 1];
        }
    }

    static void update(int node, int start, int end, int idx, int value) {
        if (start == end) {
            tree[node] = idx;
            arr[idx] = value;
            return;
        }

        int mid = (start + end) / 2;

        if (idx <= mid) {
            update(node * 2, start, mid, idx, value);
        } else {
            update(node * 2 + 1, mid + 1, end, idx, value);
        }

        if (arr[tree[node * 2]] <= arr[tree[node * 2 + 1]]) {
            tree[node] = tree[node * 2];
        } else {
            tree[node] = tree[node * 2 + 1];
        }
    }

    static int query(int node, int start, int end, int left, int right) {
        if (right < start || left > end) return -1;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;

        int leftMin = query(node * 2, start, mid, left, right);
        int rightMin = query(node * 2 + 1, mid + 1, end, left, right);

        if (leftMin == -1) {
            return rightMin;
        } else if (rightMin == -1) {
            return leftMin;
        } else {
            if (arr[leftMin] <= arr[rightMin]) {
                return leftMin;
            } else {
                return rightMin;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        arr = new int[1 + n];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        tree = new int[4 * n];
        init(1, 1, n);

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (t == 1) {
                update(1, 1, n, a, b);
            } else {
                sb.append(query(1, 1, n, a, b)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
