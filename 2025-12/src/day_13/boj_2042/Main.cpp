#include <bits/stdc++.h>
using namespace std;

struct SegTree {
    int n;
    vector<long long> tree;

    SegTree(int n) : n(n), tree(4 * n) {
    }

    void init(const vector<long long>& arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        init(arr, node * 2, start, mid);
        init(arr, node * 2 + 1, mid + 1, end);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    void update(int node, int start, int end, int idx, long long value) {
        if (start == end) {
            tree[node] = value;
            return;
        }

        int mid = (start + end) / 2;

        if (idx <= mid) {
            update(node * 2, start, mid, idx, value);
        } else {
            update(node * 2 + 1, mid + 1, end, idx, value);
        }
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    long long querySum(int node, int start, int end, int left, int right) {
        if (left > end || right < start) return 0;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;

        long long leftSum = querySum(node * 2, start, mid, left, right);
        long long rightSum = querySum(node * 2 + 1, mid + 1, end, left, right);
        return leftSum + rightSum;
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m, k;
    cin >> n >> m >> k;

    vector<long long> v(n);
    for (long long& x : v) cin >> x;

    SegTree tree(n);
    tree.init(v, 1, 0, n - 1);

    for (int i = 0; i < m + k; i++) {
        int a, b;
        long long c;
        cin >> a >> b >> c;

        if (a == 1) {
            tree.update(1, 0, n - 1, b - 1, c);
        } else {
            cout << tree.querySum(1, 0, n - 1, b - 1, (int)(c - 1)) << '\n';
        }
    }
}
