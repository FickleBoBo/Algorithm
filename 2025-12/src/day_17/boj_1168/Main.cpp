#include <bits/stdc++.h>
using namespace std;

struct SegTree {
    int n;
    vector<int> tree;

    SegTree(int n) : n(n), tree(4 * n) {
    }

    void init(int node, int start, int end) {
        if (start == end) {
            tree[node] = 1;
            return;
        }

        int mid = (start + end) / 2;

        init(node * 2, start, mid);
        init(node * 2 + 1, mid + 1, end);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    void update(int node, int start, int end, int idx) {
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

    int n, k;
    cin >> n >> k;

    SegTree tree(n);
    tree.init(1, 1, n);
    int alive = n;
    int cur = 0;

    cout << '<';
    for (int i = 0; i < n; i++) {
        cur = (cur + k - 1) % alive;

        int idx = tree.queryKth(1, 1, n, cur + 1);
        tree.update(1, 1, n, idx);
        alive--;

        cout << idx;
        if (i != n - 1) cout << ", ";
    }
    cout << '>';
}
