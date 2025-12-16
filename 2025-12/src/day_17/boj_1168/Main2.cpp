#include <bits/stdc++.h>
using namespace std;

struct Fenwick {
    int n;
    vector<int> tree;

    Fenwick(int n) : n(n), tree(1 + n) {
    }

    void add(int idx, int delta) {
        while (idx <= n) {
            tree[idx] += delta;
            idx += idx & -idx;
        }
    }

    int kth(int k) {
        int pos = 0;
        int bit = 1 << 17;

        while (bit > 0) {
            int next = pos + bit;
            if (next <= n && tree[next] < k) {
                k -= tree[next];
                pos = next;
            }
            bit >>= 1;
        }

        return pos + 1;
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;

    Fenwick tree(n);
    for (int i = 1; i <= n; i++) {
        tree.add(i, 1);
    }

    int alive = n;
    int cur = 0;

    cout << '<';
    for (int i = 0; i < n; i++) {
        cur = (cur + k - 1) % alive;

        int idx = tree.kth(cur + 1);
        tree.add(idx, -1);
        alive--;

        cout << idx;
        if (i != n - 1) cout << ", ";
    }
    cout << '>';
}
