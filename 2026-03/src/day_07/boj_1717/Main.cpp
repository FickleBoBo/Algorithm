#include <bits/stdc++.h>
using namespace std;

vector<int> p(1000001, -1);

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

    int n, m;
    cin >> n >> m;

    while (m--) {
        int q, a, b;
        cin >> q >> a >> b;

        if (q == 0) {
            unite(a, b);
        } else {
            if (find(a) == find(b)) {
                cout << "YES\n";
            } else {
                cout << "NO\n";
            }
        }
    }
}
