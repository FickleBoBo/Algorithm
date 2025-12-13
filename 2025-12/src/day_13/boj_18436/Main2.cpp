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

    long long query(int idx) const {
        long long res = 0;
        while (idx > 0) {
            res += tree[idx];
            idx -= idx & -idx;
        }
        return res;
    }

    long long query(int left, int right) const {
        return query(right) - query(left - 1);
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> v(1 + n);
    Fenwick tree(n);
    for (int i = 1; i <= n; i++) {
        cin >> v[i];
        v[i] %= 2;
        tree.add(i, v[i]);
    }

    int m;
    cin >> m;

    for (int i = 0; i < m; i++) {
        int t, a, b;
        cin >> t >> a >> b;

        if (t == 1) {
            tree.add(a, b % 2 - v[a]);
            v[a] = b % 2;
        } else if (t == 2) {
            cout << (b - a + 1) - tree.query(a, b) << '\n';
        } else {
            cout << tree.query(a, b) << '\n';
        }
    }
}
