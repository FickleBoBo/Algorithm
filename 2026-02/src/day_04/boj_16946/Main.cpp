#include <bits/stdc++.h>
using namespace std;

int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};
int n, m;
char grid[1001][1001];
bool visited[1001][1001];
int cntGrid[1001][1001];

void bfs(int sr, int sc) {
    queue<pair<int, int>> q;
    q.push({sr, sc});

    visited[sr][sc] = true;

    int cnt = 1;

    queue<pair<int, int>> q2;

    while (!q.empty()) {
        auto [r, c] = q.front();
        q.pop();

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            if (visited[nr][nc]) continue;
            if (grid[nr][nc] == '1') {
                q2.push({nr, nc});
                visited[nr][nc] = true;
                continue;
            }

            q.push({nr, nc});
            visited[nr][nc] = true;
            cnt++;
        }
    }

    while (!q2.empty()) {
        auto [r, c] = q2.front();
        q2.pop();

        cntGrid[r][c] += cnt;
        visited[r][c] = false;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        cin >> grid[i];
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (grid[i][j] == '1') cntGrid[i][j] = 1;
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (grid[i][j] == '1' || visited[i][j]) continue;

            bfs(i, j);
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cout << cntGrid[i][j] % 10;
        }
        cout << '\n';
    }
}
