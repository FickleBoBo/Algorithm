#include <bits/stdc++.h>
using namespace std;

int n, m;
vector<vector<int>> adj(1 + 1000);
bool visited[1 + 1000];

void bfs(int start) {
    queue<int> q;
    q.push(start);

    visited[start] = true;

    while (!q.empty()) {
        int node = q.front();
        q.pop();

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

        bfs(node);
        cnt++;
    }

    cout << cnt;
}
