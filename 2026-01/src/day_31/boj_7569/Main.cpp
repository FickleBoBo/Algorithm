#include <bits/stdc++.h>
using namespace std;

int dz[6] = {0, 0, 0, 0, -1, 1};
int dr[6] = {-1, 0, 1, 0, 0, 0};
int dc[6] = {0, 1, 0, -1, 0, 0};
int grid[100][100][100];
int dist[100][100][100];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int h, n, m;
    cin >> m >> n >> h;

    queue<tuple<int, int, int>> q;
    memset(dist, -1, sizeof(dist));
    int cnt = 0;

    for (int i = 0; i < h; i++) {
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                cin >> grid[i][j][k];

                if (grid[i][j][k] == 1) {
                    q.push({i, j, k});
                    dist[i][j][k] = 0;
                } else if (grid[i][j][k] == 0) {
                    cnt++;
                }
            }
        }
    }

    if (cnt == 0) {
        cout << 0;
        return 0;
    }

    while (!q.empty()) {
        auto [z, r, c] = q.front();
        q.pop();

        for (int d = 0; d < 6; d++) {
            int nz = z + dz[d];
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nz < 0 || nz >= h || nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            if (grid[nz][nr][nc] != 0 || dist[nz][nr][nc] != -1) continue;

            q.push({nz, nr, nc});
            dist[nz][nr][nc] = dist[z][r][c] + 1;
        }
    }

    int mx = -1;
    for (int i = 0; i < h; i++) {
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                if (grid[i][j][k] == 0 && dist[i][j][k] == -1) {
                    cout << -1;
                    return 0;
                }

                mx = max(mx, dist[i][j][k]);
            }
        }
    }

    cout << mx;
}
