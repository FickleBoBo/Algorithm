#include <bits/stdc++.h>
using namespace std;

int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};
int n, m;
char grid[601][601];
bool visited[601][601];

int dfs(int r, int c) {
    visited[r][c] = true;
    int cnt = grid[r][c] == 'P';

    for (int d = 0; d < 4; d++) {
        int nr = r + dr[d];
        int nc = c + dc[d];

        if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
        if (grid[nr][nc] == 'X' || visited[nr][nc]) continue;

        cnt += dfs(nr, nc);
    }

    return cnt;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n >> m;

    int sr, sc;
    for (int i = 0; i < n; i++) {
        cin >> grid[i];
        for (int j = 0; j < m; j++) {
            if (grid[i][j] == 'I') {
                sr = i;
                sc = j;
            }
        }
    }

    int cnt = dfs(sr, sc);
    if (cnt > 0) {
        cout << cnt;
    } else {
        cout << "TT";
    }
}
