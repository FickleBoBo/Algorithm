#include <bits/stdc++.h>
using namespace std;

int n;
bool adj[101][101];
bool visited[101];

int dfs(int node) {
    visited[node] = true;
    int cnt = 1;

    for (int next = 1; next <= n; next++) {
        if (!adj[node][next] || visited[next]) continue;
        cnt += dfs(next);
    }

    return cnt;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int m;
    cin >> n >> m;

    for (int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v;
        adj[u][v] = adj[v][u] = true;
    }

    cout << dfs(1) - 1;
}
