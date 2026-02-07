#include <bits/stdc++.h>
using namespace std;

int n;
vector<int> adj[501];
bool visited[501];

int bfs() {
    queue<int> q;
    q.push(1);

    visited[1] = true;

    int dist = 0;
    int cnt = 0;

    while (!q.empty()) {
        int sz = q.size();

        while (sz--) {
            int node = q.front();
            q.pop();

            for (int next : adj[node]) {
                if (visited[next]) continue;

                q.push(next);
                visited[next] = true;
                cnt++;
            }
        }

        dist++;
        if (dist == 2) break;
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
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    cout << bfs();
}
