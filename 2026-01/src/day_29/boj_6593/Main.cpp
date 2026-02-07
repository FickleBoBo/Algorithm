#include <bits/stdc++.h>
using namespace std;

int dz[6] = {0, 0, 0, 0, -1, 1};
int dr[6] = {-1, 0, 1, 0, 0, 0};
int dc[6] = {0, 1, 0, -1, 0, 0};
int h, n, m;
char grid[30][30][30];
bool visited[30][30][30];

struct Node {
    int z, r, c;
};

int bfs(Node& s, Node& e) {
    queue<Node> q;
    q.push(s);

    visited[s.z][s.r][s.c] = true;

    int dist = 0;

    while (!q.empty()) {
        int sz = q.size();

        while (sz--) {
            auto [z, r, c] = q.front();
            q.pop();

            if (z == e.z && r == e.r && c == e.c) return dist;

            for (int d = 0; d < 6; d++) {
                int nz = z + dz[d];
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nz < 0 || nz >= h || nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (grid[nz][nr][nc] == '#' || visited[nz][nr][nc]) continue;

                q.push({nz, nr, nc});
                visited[nz][nr][nc] = true;
            }
        }

        dist++;
    }

    return -1;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    while (true) {
        cin >> h >> n >> m;

        if (h == 0 && n == 0 && m == 0) break;

        memset(visited, 0, sizeof(visited));

        Node s, e;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                string input;
                cin >> input;

                for (int k = 0; k < m; k++) {
                    grid[i][j][k] = input[k];

                    if (grid[i][j][k] == 'S') {
                        s = {i, j, k};
                    } else if (grid[i][j][k] == 'E') {
                        e = {i, j, k};
                    }
                }
            }
        }

        int dist = bfs(s, e);
        if (dist == -1) {
            cout << "Trapped!\n";
        } else {
            cout << "Escaped in " << dist << " minute(s).\n";
        }
    }
}
