#include <bits/stdc++.h>
using namespace std;

int dr[8] = {-1, -1, -1, 0, 1, 1, 1, 0};
int dc[8] = {-1, 0, 1, 1, 1, 0, -1, -1};
int h, w;
int grid[50][50];

void dfs(int r, int c) {
    grid[r][c] = 0;

    for (int d = 0; d < 8; d++) {
        int nr = r + dr[d];
        int nc = c + dc[d];

        if (nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
        if (grid[nr][nc] == 0) continue;

        dfs(nr, nc);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    while (true) {
        cin >> w >> h;
        if (w == 0 || h == 0) break;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                cin >> grid[i][j];
            }
        }

        int cnt = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        cout << cnt << '\n';
    }
}
