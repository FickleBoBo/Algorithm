#include <bits/stdc++.h>
using namespace std;

int n;
bool adj[101][101];
bool visited[101];

int bfs(int x, int y) {
    queue<int> q;
    q.push(x);

    visited[x] = true;

    int dist = 0;

    while (!q.empty()) {
        int sz = q.size();

        while (sz--) {
            int node = q.front();
            q.pop();

            if (node == y) return dist;

            for (int next = 1; next <= n; next++) {
                if (!adj[node][next] || visited[next]) continue;

                q.push(next);
                visited[next] = true;
            }
        }

        dist++;
    }

    return -1;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int x, y, m;
    cin >> n >> x >> y >> m;

    for (int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v;
        adj[u][v] = adj[v][u] = true;
    }

    cout << bfs(x, y);
}
