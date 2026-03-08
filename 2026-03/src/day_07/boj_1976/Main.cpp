#include <bits/stdc++.h>
using namespace std;

vector<int> p(201, -1);

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

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            int x;
            cin >> x;
            if (x == 1) unite(i, j);
        }
    }

    int x;
    cin >> x;

    int root = find(x);
    m--;

    while (m--) {
        cin >> x;
        if (root != find(x)) {
            cout << "NO";
            return 0;
        }
    }

    cout << "YES";
}
