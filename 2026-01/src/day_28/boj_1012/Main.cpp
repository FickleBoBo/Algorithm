#include <bits/stdc++.h>
using namespace std;

int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};
int n, m;
bool grid[50][50];

void bfs(int sr, int sc) {
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

    while (t--) {
        int k;
        cin >> m >> n >> k;

        memset(grid, 0, sizeof(grid));
        for (int i = 0; i < k; i++) {
            int c, r;
            cin >> c >> r;
            grid[r][c] = true;
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }

        cout << cnt << '\n';
    }
}
