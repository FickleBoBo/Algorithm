#include <bits/stdc++.h>
using namespace std;

struct SegTree {
    int n;
    vector<int> tree;

    SegTree(int n) : n(n), tree(4 * n) {
    }

    void init(const vector<int>& arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        init(arr, node * 2, start, mid);
        init(arr, node * 2 + 1, mid + 1, end);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    void update(int node, int start, int end, int idx, int value) {
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

    int querySum(int node, int start, int end, int left, int right) {
        if (left > end || right < start) return 0;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;

        int leftSum = querySum(node * 2, start, mid, left, right);
        int rightSum = querySum(node * 2 + 1, mid + 1, end, left, right);
        return leftSum + rightSum;
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> v(n);
    for (int& x : v) {
        cin >> x;
        x %= 2;
    }

    SegTree tree(n);
    tree.init(v, 1, 0, n - 1);

    int m;
    cin >> m;

    for (int i = 0; i < m; i++) {
        int t, a, b;
        cin >> t >> a >> b;

        if (t == 1) {
            tree.update(1, 0, n - 1, a - 1, b % 2);
        } else if (t == 2) {
            cout << (b - a + 1) - tree.querySum(1, 0, n - 1, a - 1, b - 1) << '\n';
        } else {
            cout << tree.querySum(1, 0, n - 1, a - 1, b - 1) << '\n';
        }
    }
}
