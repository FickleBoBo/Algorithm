#include <bits/stdc++.h>
using namespace std;

constexpr int MAX = 2000000;

struct SegTree {
    int n;
    vector<int> tree;

    SegTree(int n) : n(n), tree(4 * n) {
    }

    void update(int node, int start, int end, int idx, int delta) {
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

    int queryKth(int node, int start, int end, int k) {
        if (start == end) return start;

        int mid = (start + end) / 2;

        if (k <= tree[node * 2]) {
            return queryKth(node * 2, start, mid, k);
        } else {
            return queryKth(node * 2 + 1, mid + 1, end, k - tree[node * 2]);
        }
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    SegTree tree(MAX);

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        int t, x;
        cin >> t >> x;

        if (t == 1) {
            tree.update(1, 1, MAX, x, 1);
        } else {
            int k = tree.queryKth(1, 1, MAX, x);
            tree.update(1, 1, MAX, k, -1);
            cout << k << '\n';
        }
    }
}
