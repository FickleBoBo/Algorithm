#include <bits/stdc++.h>
using namespace std;

int n;
bool adj[101][101];
bool visited[101];

int bfs() {
    queue<int> q;
    q.push(1);

    visited[1] = true;

    int cnt = 0;

    while (!q.empty()) {
        int node = q.front();
        q.pop();

        for (int next = 1; next <= n; next++) {
            if (!adj[node][next] || visited[next]) continue;

            q.push(next);
            visited[next] = true;
            cnt++;
        }
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

    cout << bfs();
}
