#include <bits/stdc++.h>
using namespace std;

struct Fenwick {
    int n;
    vector<long long> tree;

    Fenwick(int n) : n(n), tree(1 + n) {
    }

    void modify(int idx, long long delta) {
        while (idx <= n) {
            tree[idx] += delta;
            idx += idx & -idx;
        }
    }

    long long sum(int idx) {
        long long res = 0;
        while (idx > 0) {
            res += tree[idx];
            idx -= idx & -idx;
        }
        return res;
    }

    long long sum(int left, int right) {
        return sum(right) - sum(left - 1);
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    Fenwick tree(n);
    vector<long long> v(1 + n);

    for (int i = 0; i < m; i++) {
        int t, a, b;
        cin >> t >> a >> b;

        if (t == 0) {
            cout << tree.sum(min(a, b), max(a, b)) << '\n';
        } else {
            tree.modify(a, b - v[a]);
            v[a] = b;
        }
    }
}
