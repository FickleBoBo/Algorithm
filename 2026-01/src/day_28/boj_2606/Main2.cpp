#include <bits/stdc++.h>
using namespace std;

int n;
bool adj[101][101];
bool vis[101];

int dfs(int cur) {
    vis[cur] = true;
    int cnt = 1;

    for (int nxt = 1; nxt <= n; nxt++) {
        if (!adj[cur][nxt] || vis[nxt]) continue;
        cnt += dfs(nxt);
    }

    return cnt;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int m;
    cin >> n >> m;

    while (m--) {
        int u, v;
        cin >> u >> v;
        adj[u][v] = adj[v][u] = true;
    }

    cout << dfs(1) - 1;
}
