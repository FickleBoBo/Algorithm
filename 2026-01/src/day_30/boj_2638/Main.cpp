#include <bits/stdc++.h>
using namespace std;

int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};
int n, m;
int grid[100][100];
bool visited[100][100];
bool check[100][100];

bool bfs() {
    queue<pair<int, int>> q;
    q.push({0, 0});

    visited[0][0] = true;

    vector<pair<int, int>> v;

    while (!q.empty()) {
        auto [r, c] = q.front();
        q.pop();

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            if (visited[nr][nc]) continue;
            if (grid[nr][nc] == 1) {
                if (check[nr][nc]) {
                    v.push_back({nr, nc});
                } else {
                    check[nr][nc] = true;
                }
                continue;
            }

            q.push({nr, nc});
            visited[nr][nc] = true;
        }
    }

    if (v.empty()) return false;

    for (auto [r, c] : v) {
        grid[r][c] = 0;
    }

    return true;
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

    int time = 0;
    while (true) {
        memset(visited, 0, sizeof(visited));
        memset(check, 0, sizeof(check));

        bool flag = bfs();

        if (!flag) break;
        time++;
    }

    cout << time;
}
