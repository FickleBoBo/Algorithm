#include <bits/stdc++.h>
using namespace std;

int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};
int n, m;
int grid[1000][1000];
bool visited[1000][1000];
queue<pair<int, int>> q;

int bfs(int cnt) {
    int dist = 0;

    while (!q.empty()) {
        int sz = q.size();

        while (sz--) {
            auto [r, c] = q.front();
            q.pop();

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (grid[nr][nc] != 0 || visited[nr][nc]) continue;

                q.push({nr, nc});
                visited[nr][nc] = true;
                cnt--;
            }
        }

        dist++;
        if (cnt == 0) return dist;
    }

    return -1;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> m >> n;

    int cnt = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> grid[i][j];

            if (grid[i][j] == 1) {
                q.push({i, j});
                visited[i][j] = true;
            } else if (grid[i][j] == 0) {
                cnt++;
            }
        }
    }

    if (cnt == 0) {
        cout << cnt;
    } else {
        cout << bfs(cnt);
    }
}
