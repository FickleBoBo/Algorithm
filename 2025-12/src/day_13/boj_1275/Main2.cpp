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

    vector<int> v(1 + n);
    Fenwick tree(n);

    for (int i = 1; i <= n; i++) {
        cin >> v[i];
        tree.add(i, v[i]);
    }

    for (int i = 0; i < q; i++) {
        int x, y, a, b;
        cin >> x >> y >> a >> b;

        cout << tree.query(min(x, y), max(x, y)) << '\n';
        tree.add(a, (long long)b - v[a]);
        v[a] = b;
    }
}
