#include <bits/stdc++.h>
using namespace std;

int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};

char grid[100][100];
bool visited[100][100];

int bfs(int n, int m) {
    queue<pair<int, int>> q;
    q.push({0, 0});

    visited[0][0] = true;

    int dist = 1;

    while (!q.empty()) {
        int sz = q.size();

        while (sz--) {
            auto [r, c] = q.front();
            q.pop();

            if (r == n - 1 && c == m - 1) return dist;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (grid[nr][nc] != '1') continue;
                if (visited[nr][nc]) continue;

                q.push({nr, nc});
                visited[nr][nc] = true;
            }
        }

        dist++;
    }

    return -1;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        string s;
        cin >> s;

        for (int j = 0; j < m; j++) {
            grid[i][j] = s[j];
        }
    }

    int dist = bfs(n, m);
    cout << dist;
}
