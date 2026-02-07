#include <bits/stdc++.h>
using namespace std;

int p[1001];

void make(int n) {
    for (int i = 1; i <= n; i++) p[i] = i;
}

int find(int x) {
    if (x == p[x]) return x;
    return p[x] = find(p[x]);
}

void unite(int x, int y) {
    p[find(y)] = find(x);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    make(n);

    for (int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v;
        unite(u, v);
    }

    int cnt = 0;
    for (int node = 1; node <= n; node++) {
        if (node == find(node)) cnt++;
    }

    cout << cnt;
}
