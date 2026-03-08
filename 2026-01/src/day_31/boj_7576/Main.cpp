#include <bits/stdc++.h>
using namespace std;

int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};
int grid[1000][1000];
int dist[1000][1000];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> m >> n;

    queue<pair<int, int>> q;
    memset(dist, -1, sizeof(dist));
    int cnt = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> grid[i][j];

            if (grid[i][j] == 1) {
                q.push({i, j});
                dist[i][j] = 0;
            } else if (grid[i][j] == 0) {
                cnt++;
            }
        }
    }

    if (cnt == 0) {
        cout << 0;
        return 0;
    }

    while (!q.empty()) {
        auto [r, c] = q.front();
        q.pop();

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            if (grid[nr][nc] != 0 || dist[nr][nc] != -1) continue;

            q.push({nr, nc});
            dist[nr][nc] = dist[r][c] + 1;
        }
    }

    int mx = -1;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (grid[i][j] == 0 && dist[i][j] == -1) {
                cout << -1;
                return 0;
            }

            mx = max(mx, dist[i][j]);
        }
    }

    cout << mx;
}
