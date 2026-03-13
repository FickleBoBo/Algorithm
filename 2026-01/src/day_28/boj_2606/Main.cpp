#include <bits/stdc++.h>
using namespace std;

int n;
bool adj[101][101];
bool vis[101];

int bfs() {
    queue<int> q;
    q.push(1);

    vis[1] = true;

    int cnt = 0;

    while (!q.empty()) {
        int cur = q.front();
        q.pop();

        for (int nxt = 1; nxt <= n; nxt++) {
            if (!adj[cur][nxt] || vis[nxt]) continue;

            q.push(nxt);
            vis[nxt] = true;
            cnt++;
        }
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

    cout << bfs();
}
