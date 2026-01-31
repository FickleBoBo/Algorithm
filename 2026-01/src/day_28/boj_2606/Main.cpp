#include <bits/stdc++.h>
using namespace std;

bool adj[1 + 100][1 + 100];
bool visited[1 + 100];

int bfs(int n) {
    queue<int> q;
    q.push(1);

    visited[1] = true;

    int cnt = 0;

    while (!q.empty()) {
        int node = q.front();
        q.pop();

        for (int next = 1; next <= n; next++) {
            if (adj[node][next] && !visited[next]) {
                q.push(next);
                visited[next] = true;
                cnt++;
            }
        }
    }

    return cnt;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    for (int i = 0; i < m; i++) {
        int x, y;
        cin >> x >> y;
        adj[x][y] = adj[y][x] = true;
    }

    int cnt = bfs(n);
    cout << cnt << '\n';
}
