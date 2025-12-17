#include <bits/stdc++.h>
using namespace std;

struct Fenwick {
    int n;
    vector<long long> tree;

    Fenwick(int n) : n(n), tree(1 + n) {
    }

    void add(int idx, long long delta) {
        while (idx <= n) {
            tree[idx] += delta;
            idx += idx & -idx;
        }
    }

    long long query(int idx) {
        long long res = 0;
        while (idx > 0) {
            res += tree[idx];
            idx -= idx & -idx;
        }
        return res;
    }

    long long query(int left, int right) {
        return query(right) - query(left - 1);
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, q;
    cin >> n >> q;

    Fenwick tree(n);
    for (int i = 0; i < q; i++) {
        int t, a, b;
        cin >> t >> a >> b;

        if (t == 1) {
            tree.add(a, b);
        } else {
            cout << tree.query(a, b) << '\n';
        }
    }
}
