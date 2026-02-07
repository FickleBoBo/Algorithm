#include <bits/stdc++.h>
using namespace std;

int n;
vector<int> adj[100001];
bool visited[100001];
int order[100001];
int cnt = 1;

void dfs(int node) {
    visited[node] = true;
    order[node] = cnt++;

    for (int next : adj[node]) {
        if (visited[next]) continue;
        dfs(next);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int m, r;
    cin >> n >> m >> r;

    for (int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    for (int i = 1; i <= n; i++) {
        sort(adj[i].rbegin(), adj[i].rend());
    }

    dfs(r);

    for (int i = 1; i <= n; i++) {
        cout << order[i] << '\n';
    }
}
