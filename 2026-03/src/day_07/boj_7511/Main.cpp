#include <bits/stdc++.h>
using namespace std;

vector<int> p(1000000);

int find(int x) {
    if (p[x] < 0) return x;
    return p[x] = find(p[x]);
}

void unite(int x, int y) {
    x = find(x);
    y = find(y);
    if (x != y) p[y] = x;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;

    for (int tc = 1; tc <= t; tc++) {
        int n, k;
        cin >> n >> k;

        fill(p.begin(), p.begin() + n, -1);
        while (k--) {
            int a, b;
            cin >> a >> b;
            unite(a, b);
        }

        int m;
        cin >> m;

        cout << "Scenario " << tc << ":\n";
        while (m--) {
            int u, v;
            cin >> u >> v;
            cout << (find(u) == find(v)) << '\n';
        }
        cout << '\n';
    }
}
