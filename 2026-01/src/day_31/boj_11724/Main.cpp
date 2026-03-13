#include <bits/stdc++.h>
using namespace std;

vector<int> adj[1001];
bool vis[1001];

void bfs(int start) {
    queue<int> q;
    q.push(start);

    vis[start] = true;

    while (!q.empty()) {
        int cur = q.front();
        q.pop();

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

        bfs(cur);
        cnt++;
    }

    cout << cnt;
}
