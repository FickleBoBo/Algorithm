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
        tree[node] = tree[node * 2] * tree[node * 2 + 1];
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
        tree[node] = tree[node * 2] * tree[node * 2 + 1];
    }

    int queryMul(int node, int start, int end, int left, int right) {
        if (left > end || right < start) return 1;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;

        int leftMul = queryMul(node * 2, start, mid, left, right);
        int rightMul = queryMul(node * 2 + 1, mid + 1, end, left, right);
        return leftMul * rightMul;
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    while (cin >> n >> k) {
        vector<int> v(n);
        for (int& x : v) {
            cin >> x;
            x = (x > 0) - (x < 0);
        }

        SegTree tree(n);
        tree.init(v, 1, 0, n - 1);

        for (int i = 0; i < k; i++) {
            string command;
            int a, b;
            cin >> command >> a >> b;

            if (command == "C") {
                tree.update(1, 0, n - 1, a - 1, (b > 0) - (b < 0));
            } else {
                int res = tree.queryMul(1, 0, n - 1, a - 1, b - 1);

                if (res > 0) {
                    cout << '+';
                } else if (res < 0) {
                    cout << '-';
                } else {
                    cout << '0';
                }
            }
        }
        cout << '\n';
    }
}
