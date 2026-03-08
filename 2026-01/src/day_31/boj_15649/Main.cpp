#include <bits/stdc++.h>
using namespace std;

int n, m;
int sel[8];
bool vis[9];

void dfs(int sidx) {
    if (sidx == m) {
        for (int i = 0; i < m; i++) {
            cout << sel[i] << ' ';
        }
        cout << '\n';
        return;
    }

    for (int i = 1; i <= n; i++) {
        if (vis[i]) continue;

        sel[sidx] = i;
        vis[i] = true;
        dfs(sidx + 1);
        vis[i] = false;
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;

    dfs(0);
}
