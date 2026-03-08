#include <bits/stdc++.h>
using namespace std;

const int MX = 100000;
vector<int> adj[1 + MX];
bool vis[1 + MX];
int order[1 + MX];

void bfs(int start) {
    queue<int> q;
    q.push(start);

    vis[start] = true;

    int cnt = 1;

    while (!q.empty()) {
        int cur = q.front();
        q.pop();

        order[cur] = cnt++;

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

    int n, m, r;
    cin >> n >> m >> r;

    while (m--) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    for (int i = 1; i <= n; i++) {
        sort(adj[i].begin(), adj[i].end());
    }

    bfs(r);

    for (int i = 1; i <= n; i++) {
        cout << order[i] << '\n';
    }
}
