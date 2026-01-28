#include <bits/stdc++.h>
using namespace std;

int n;
int adj[1 + 100][1 + 100];
bool visited[1 + 100];
int cnt = 0;

void dfs(int node) {
    visited[node] = true;
    cnt++;

    for (int next = 1; next <= n; next++) {
        if (adj[node][next] && !visited[next]) {
            dfs(next);
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int m;
    cin >> n >> m;

    for (int i = 0; i < m; i++) {
        int x, y;
        cin >> x >> y;
        adj[x][y] = true;
        adj[y][x] = true;
    }

    dfs(1);
    cout << cnt - 1 << '\n';
}
