#include <bits/stdc++.h>
using namespace std;

constexpr int MAX = 2000000;

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
        int bit = 1 << 21;

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

    Fenwick tree(MAX);

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        int t, x;
        cin >> t >> x;

        if (t == 1) {
            tree.add(x, 1);
        } else {
            int k = tree.kth(x);
            tree.add(k, -1);
            cout << k << '\n';
        }
    }
}
