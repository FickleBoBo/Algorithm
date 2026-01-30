#include <bits/stdc++.h>
using namespace std;

int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};

int n, m;
int grid[500][500];

int bfs(int sr, int sc) {
    queue<pair<int, int>> q;
    q.push({sr, sc});

    grid[sr][sc] = 0;

    int cnt = 1;

    while (!q.empty()) {
        auto [r, c] = q.front();
        q.pop();

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            if (grid[nr][nc] == 0) continue;

            q.push({nr, nc});
            grid[nr][nc] = 0;
            cnt++;
        }
    }

    return cnt;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> grid[i][j];
        }
    }

    int cnt = 0;
    int mx = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (grid[i][j] == 1) {
                int res = bfs(i, j);
                cnt++;
                mx = max(mx, res);
            }
        }
    }

    cout << cnt << '\n';
    cout << mx << '\n';
}
