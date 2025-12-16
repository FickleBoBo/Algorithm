#include <bits/stdc++.h>
using namespace std;

constexpr int MIN = 0;
constexpr int MAX = 1000000001;

struct SegTree {
    int n;
    vector<pair<int, int>> tree;

    SegTree(int n) : n(n), tree(4 * n) {
    }

    void init(const vector<int>& arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = {arr[start], arr[start]};
            return;
        }

        int mid = (start + end) / 2;

        init(arr, node * 2, start, mid);
        init(arr, node * 2 + 1, mid + 1, end);
        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    pair<int, int> merge(pair<int, int> a, pair<int, int> b) {
        return {min(a.first, b.first), max(a.second, b.second)};
    }

    pair<int, int> query(int node, int start, int end, int left, int right) {
        if (left > end || right < start) return {MAX, MIN};
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

    int n, m;
    cin >> n >> m;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    SegTree tree(n);
    tree.init(v, 1, 0, n - 1);

    for (int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;

        pair<int, int> res = tree.query(1, 0, n - 1, a - 1, b - 1);
        cout << res.first << ' ' << res.second << '\n';
    }
}
