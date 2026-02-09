#include <bits/stdc++.h>
using namespace std;

vector<int> adj[1001];
bool visited[1001];

void dfs(int node) {
    visited[node] = true;
    cout << node << ' ';

    for (int next : adj[node]) {
        if (visited[next]) continue;
        dfs(next);
    }
}

void bfs(int start) {
    queue<int> q;
    q.push(start);

    visited[start] = true;

    while (!q.empty()) {
        int node = q.front();
        q.pop();

        cout << node << ' ';

        for (int next : adj[node]) {
            if (visited[next]) continue;

            q.push(next);
            visited[next] = true;
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m, k;
    cin >> n >> m >> k;

    for (int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    for (int i = 1; i <= n; i++) {
        sort(adj[i].begin(), adj[i].end());
    }

    dfs(k);

    cout << '\n';

    memset(visited, 0, sizeof(visited));
    bfs(k);
}
