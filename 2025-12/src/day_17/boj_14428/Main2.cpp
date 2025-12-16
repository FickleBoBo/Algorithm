#include <bits/stdc++.h>
using namespace std;

struct SegTree {
    int n;
    vector<int> tree;

    SegTree(int n) : n(n), tree(4 * n) {
    }

    void init(const vector<int>& arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = start;
            return;
        }

        int mid = (start + end) / 2;

        init(arr, node * 2, start, mid);
        init(arr, node * 2 + 1, mid + 1, end);

        if (arr[tree[node * 2]] <= arr[tree[node * 2 + 1]]) {
            tree[node] = tree[node * 2];
        } else {
            tree[node] = tree[node * 2 + 1];
        }
    }

    void update(vector<int>& arr, int node, int start, int end, int idx, int value) {
        if (start == end) {
            tree[node] = idx;
            arr[idx] = value;
            return;
        }

        int mid = (start + end) / 2;

        if (idx <= mid) {
            update(arr, node * 2, start, mid, idx, value);
        } else {
            update(arr, node * 2 + 1, mid + 1, end, idx, value);
        }

        if (arr[tree[node * 2]] <= arr[tree[node * 2 + 1]]) {
            tree[node] = tree[node * 2];
        } else {
            tree[node] = tree[node * 2 + 1];
        }
    }

    int query(const vector<int>& arr, int node, int start, int end, int left, int right) {
        if (left > end || right < start) return -1;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;

        int leftMin = query(arr, node * 2, start, mid, left, right);
        int rightMin = query(arr, node * 2 + 1, mid + 1, end, left, right);

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
            tree.update(v, 1, 0, n - 1, a - 1, b);
        } else {
            cout << tree.query(v, 1, 0, n - 1, a - 1, b - 1) + 1 << '\n';
        }
    }
}
