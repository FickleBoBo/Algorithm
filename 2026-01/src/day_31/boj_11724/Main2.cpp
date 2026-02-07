#include <bits/stdc++.h>
using namespace std;

vector<int> adj[1001];
bool visited[1001];

void dfs(int node) {
    visited[node] = true;

    for (int next : adj[node]) {
        if (visited[next]) continue;
        dfs(next);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    for (int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    int cnt = 0;
    for (int node = 1; node <= n; node++) {
        if (visited[node]) continue;

        dfs(node);
        cnt++;
    }

    cout << cnt;
}
