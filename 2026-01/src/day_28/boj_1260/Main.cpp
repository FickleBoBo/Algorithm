#include <bits/stdc++.h>
using namespace std;

vector<set<int>> adj(1 + 1000);
bool visited[1 + 1000];

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

    int n, m, v;
    cin >> n >> m >> v;

    for (int i = 0; i < m; i++) {
        int x, y;
        cin >> x >> y;
        adj[x].insert(y);
        adj[y].insert(x);
    }

    dfs(v);
    cout << '\n';

    memset(visited, 0, sizeof(visited));
    bfs(v);
}
