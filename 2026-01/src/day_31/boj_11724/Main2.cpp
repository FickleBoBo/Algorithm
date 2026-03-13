#include <bits/stdc++.h>
using namespace std;

vector<int> adj[1001];
bool vis[1001];

void dfs(int cur) {
    vis[cur] = true;

    for (int nxt : adj[cur]) {
        if (vis[nxt]) continue;
        dfs(nxt);
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;

    while (m--) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    int cnt = 0;
    for (int cur = 1; cur <= n; cur++) {
        if (vis[cur]) continue;

        dfs(cur);
        cnt++;
    }

    cout << cnt;
}
