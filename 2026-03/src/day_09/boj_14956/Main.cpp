#include <bits/stdc++.h>
using namespace std;

pair<int, int> dfs(int n, int m) {
    if (n == 1) return {1, 1};

    int len = n / 2;
    int area = len * len;

    int q = (m - 1) / area;
    int nxt = (m - 1) % area + 1;

    auto [x, y] = dfs(n / 2, nxt);

    if (q == 0) return {y, x};
    if (q == 1) return {x, y + len};
    if (q == 2) return {x + len, y + len};
    return {2 * len - y + 1, len - x + 1};
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;

    auto [x, y] = dfs(n, m);
    cout << x << ' ' << y;
}
