#include <bits/stdc++.h>
using namespace std;

int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};

void bfs(int sr, int sc, int n, int m, vector<vector<bool>>& grid) {
    queue<pair<int, int>> q;
    q.push({sr, sc});

    grid[sr][sc] = false;

    while (!q.empty()) {
        auto [r, c] = q.front();
        q.pop();

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            if (!grid[nr][nc]) continue;

            q.push({nr, nc});
            grid[nr][nc] = false;
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;

    for (int tc = 1; tc <= t; tc++) {
        int m, n, k;
        cin >> m >> n >> k;

        vector<vector<bool>> grid(n, vector<bool>(m));
        for (int i = 0; i < k; i++) {
            int x, y;
            cin >> x >> y;
            grid[y][x] = true;
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]) {
                    bfs(i, j, n, m, grid);
                    cnt++;
                }
            }
        }

        cout << cnt << '\n';
    }
}
