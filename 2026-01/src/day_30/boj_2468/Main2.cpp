#include <bits/stdc++.h>
using namespace std;

int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};
int n;
int grid[100][100];
bool visited[100][100];

void dfs(int r, int c, int h) {
    visited[r][c] = true;

    for (int d = 0; d < 4; d++) {
        int nr = r + dr[d];
        int nc = c + dc[d];

        if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
        if (grid[nr][nc] <= h || visited[nr][nc]) continue;

        dfs(nr, nc, h);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> grid[i][j];
        }
    }

    int mx = 0;
    for (int h = 0; h < 100; h++) {
        memset(visited, 0, sizeof(visited));
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] <= h || visited[i][j]) continue;

                dfs(i, j, h);
                cnt++;
            }
        }

        mx = max(mx, cnt);
    }

    cout << mx;
}
