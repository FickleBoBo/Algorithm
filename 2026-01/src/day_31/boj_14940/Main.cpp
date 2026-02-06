#include <bits/stdc++.h>
using namespace std;

int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};
int n, m;
int grid[1000][1000];
bool visited[1000][1000];
int dist[1000][1000];

void bfs(int sr, int sc) {
    queue<pair<int, int>> q;
    q.push({sr, sc});

    visited[sr][sc] = true;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            dist[i][j] = -grid[i][j];
        }
    }
    dist[sr][sc] = 0;

    while (!q.empty()) {
        int sz = q.size();

        while (sz--) {
            auto [r, c] = q.front();
            q.pop();

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (grid[nr][nc] == 0 || visited[nr][nc]) continue;

                q.push({nr, nc});
                visited[nr][nc] = true;
                dist[nr][nc] = dist[r][c] + 1;
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n >> m;

    int sr = -1;
    int sc = -1;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> grid[i][j];

            if (grid[i][j] == 2) {
                sr = i;
                sc = j;
            }
        }
    }

    bfs(sr, sc);

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cout << dist[i][j] << ' ';
        }
        cout << '\n';
    }
}
