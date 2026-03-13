#include <bits/stdc++.h>
using namespace std;

vector<int> adj[1001];
bool vis[1001];

void dfs(int cur) {
    vis[cur] = true;
    cout << cur << ' ';

    for (int nxt : adj[cur]) {
        if (vis[nxt]) continue;
        dfs(nxt);
    }
}

void bfs(int start) {
    queue<int> q;
    q.push(start);

    vis[start] = true;

    while (!q.empty()) {
        int cur = q.front();
        q.pop();

        cout << cur << ' ';

        for (int nxt : adj[cur]) {
            if (vis[nxt]) continue;

            q.push(nxt);
            vis[nxt] = true;
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m, k;
    cin >> n >> m >> k;

    while (m--) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    for (int i = 1; i <= n; i++) {
        sort(adj[i].begin(), adj[i].end());
    }

    memset(vis, 0, sizeof(vis));
    dfs(k);

    cout << '\n';

    memset(vis, 0, sizeof(vis));
    bfs(k);
}
