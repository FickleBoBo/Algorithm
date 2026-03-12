#include <bits/stdc++.h>
using namespace std;

int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};
int n;
char grid[101][101];
bool vis[101][101];

bool isSame(char c1, char c2, bool isBlind) {
    if (!isBlind) return c1 == c2;
    if (c1 == 'B' || c2 == 'B') return c1 == c2;
    return true;
}

void bfs(int sr, int sc, bool isBlind) {
    queue<pair<int, int>> q;
    q.push({sr, sc});

    vis[sr][sc] = true;

    while (!q.empty()) {
        auto [r, c] = q.front();
        q.pop();

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
            if (!isSame(grid[sr][sc], grid[nr][nc], isBlind) || vis[nr][nc]) continue;

            q.push({nr, nc});
            vis[nr][nc] = true;
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> grid[i];
    }

    bool isBlind = false;
    for (int tc = 1; tc <= 2; tc++) {
        memset(vis, 0, sizeof(vis));
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j]) continue;

                bfs(i, j, isBlind);
                cnt++;
            }
        }
        cout << cnt << ' ';
        isBlind = !isBlind;
    }
}
