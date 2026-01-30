#include <bits/stdc++.h>
using namespace std;

int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};

int n;
char grid[100][100];
bool visited[100][100];

void bfs(int sr, int sc) {
    queue<pair<int, int>> q;
    q.push({sr, sc});

    visited[sr][sc] = true;

    while (!q.empty()) {
        auto [r, c] = q.front();
        q.pop();

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
            if (grid[nr][nc] != grid[sr][sc] || visited[nr][nc]) continue;

            q.push({nr, nc});
            visited[nr][nc] = true;
        }
    }
}

void shift() {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 'R') grid[i][j] = 'G';
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n;

    for (int i = 0; i < n; i++) {
        string s;
        cin >> s;

        for (int j = 0; j < n; j++) {
            grid[i][j] = s[j];
        }
    }

    for (int tc = 1; tc <= 2; tc++) {
        memset(visited, 0, sizeof(visited));
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;

                bfs(i, j);
                cnt++;
            }
        }

        cout << cnt << ' ';

        shift();
    }
}
