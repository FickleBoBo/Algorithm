#include <bits/stdc++.h>
using namespace std;

int n;
bool adj[1 + 100][1 + 100];
bool visited[1 + 100];

int bfs(int a, int b) {
    queue<int> q;
    q.push(a);

    visited[a] = true;

    int dist = 0;

    while (!q.empty()) {
        int sz = q.size();

        while (sz--) {
            int node = q.front();
            q.pop();

            if (node == b) return dist;

            for (int next = 1; next <= n; next++) {
                if (adj[node][next] && !visited[next]) {
                    q.push(next);
                    visited[next] = true;
                }
            }
        }

        dist++;
    }

    return -1;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int a, b, m;
    cin >> n >> a >> b >> m;

    for (int i = 0; i < m; i++) {
        int x, y;
        cin >> x >> y;
        adj[x][y] = adj[y][x] = true;
    }

    int cnt = bfs(a, b);
    cout << cnt;
}
