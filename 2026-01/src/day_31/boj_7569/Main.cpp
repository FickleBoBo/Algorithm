#include <bits/stdc++.h>
using namespace std;

int dz[6] = {0, 0, 0, 0, -1, 1};
int dr[6] = {-1, 0, 1, 0, 0, 0};
int dc[6] = {0, 1, 0, -1, 0, 0};

struct Node {
    int z, r, c;
};

int h, n, m;
int grid[100][100][100];
bool visited[100][100][100];
queue<Node> q;

int bfs(int cnt) {
    int dist = 0;

    while (!q.empty()) {
        int sz = q.size();

        while (sz--) {
            auto [z, r, c] = q.front();
            q.pop();

            for (int d = 0; d < 6; d++) {
                int nz = z + dz[d];
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nz < 0 || nz >= h || nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (grid[nz][nr][nc] != 0 || visited[nz][nr][nc]) continue;

                q.push({nz, nr, nc});
                visited[nz][nr][nc] = true;
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

    cin >> m >> n >> h;

    int cnt = 0;

    for (int i = 0; i < h; i++) {
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                cin >> grid[i][j][k];

                if (grid[i][j][k] == 1) {
                    q.push({i, j, k});
                    visited[i][j][k] = true;
                } else if (grid[i][j][k] == 0) {
                    cnt++;
                }
            }
        }
    }

    if (cnt == 0) {
        cout << cnt;
    } else {
        cout << bfs(cnt);
    }
}
