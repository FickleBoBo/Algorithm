#include <bits/stdc++.h>
using namespace std;

int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};
int n, m, k;
char grid[1001][1001];
bool visited[1001][1001][11][2];

struct Node {
    int r, c, x, day;
};

int bfs() {
    queue<Node> q;
    q.push({0, 0, 0, 0});

    visited[0][0][0][0] = true;

    int dist = 1;

    while (!q.empty()) {
        int sz = q.size();

        while (sz--) {
            auto [r, c, x, day] = q.front();
            q.pop();

            if (r == n - 1 && c == m - 1) return dist;

            bool flag = false;
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;

                if (grid[nr][nc] == '0') {
                    if (visited[nr][nc][x][1 - day]) continue;

                    q.push({nr, nc, x, 1 - day});
                    visited[nr][nc][x][1 - day] = true;
                } else {
                    if (day == 0) {
                        if (x >= k) continue;
                        if (visited[nr][nc][x + 1][1 - day]) continue;

                        q.push({nr, nc, x + 1, 1 - day});
                        visited[nr][nc][x + 1][1 - day] = true;
                    } else {
                        flag = true;
                    }
                }
            }

            if (flag) {
                if (visited[r][c][x][1 - day]) continue;

                q.push({r, c, x, 1 - day});
                visited[r][c][x][1 - day] = true;
            }
        }

        dist++;
    }

    return -1;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n >> m >> k;

    for (int i = 0; i < n; i++) {
        cin >> grid[i];
    }

    cout << bfs();
}
