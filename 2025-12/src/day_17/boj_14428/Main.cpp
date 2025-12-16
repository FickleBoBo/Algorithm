#include <bits/stdc++.h>
using namespace std;

constexpr int MAX = 1000000001;

struct SegTree {
    int n;
    vector<pair<int, int>> tree;

    SegTree(int n) : n(n), tree(4 * n) {
    }

    void init(const vector<int>& arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = {arr[start], start};
            return;
        }

        int mid = (start + end) / 2;

        init(arr, node * 2, start, mid);
        init(arr, node * 2 + 1, mid + 1, end);
        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    void update(int node, int start, int end, int idx, int value) {
        if (start == end) {
            tree[node] = {value, idx};
            return;
        }

        int mid = (start + end) / 2;

        if (idx <= mid) {
            update(node * 2, start, mid, idx, value);
        } else {
            update(node * 2 + 1, mid + 1, end, idx, value);
        }
        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    pair<int, int> merge(pair<int, int> a, pair<int, int> b) {
        if (a.first <= b.first) return {a.first, a.second};
        return {b.first, b.second};
    }

    pair<int, int> query(int node, int start, int end, int left, int right) {
        if (left > end || right < start) return {MAX, 0};
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;

        pair<int, int> leftRes = query(node * 2, start, mid, left, right);
        pair<int, int> rightRes = query(node * 2 + 1, mid + 1, end, left, right);
        return merge(leftRes, rightRes);
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    SegTree tree(n);
    tree.init(v, 1, 0, n - 1);

    int m;
    cin >> m;

    for (int i = 0; i < m; i++) {
        int t, a, b;
        cin >> t >> a >> b;

        if (t == 1) {
            tree.update(1, 0, n - 1, a - 1, b);
        } else {
            cout << tree.query(1, 0, n - 1, a - 1, b - 1).second + 1 << '\n';
        }
    }
}
