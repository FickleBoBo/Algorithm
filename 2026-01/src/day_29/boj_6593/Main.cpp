#include <bits/stdc++.h>
using namespace std;

int dh[6] = {0, 0, 0, 0, -1, 1};
int dr[6] = {-1, 0, 1, 0, 0, 0};
int dc[6] = {0, 1, 0, -1, 0, 0};

char building[30][30][30];
bool visited[30][30][30];

struct Node {
    int h, r, c;
};

int bfs(const Node& s, const Node& e, int L, int R, int C) {
    queue<Node> q;
    q.push(s);

    visited[s.h][s.r][s.c] = true;

    int dist = 0;

    while (!q.empty()) {
        int sz = q.size();

        while (sz--) {
            auto [h, r, c] = q.front();
            q.pop();

            if (h == e.h && r == e.r && c == e.c) return dist;

            for (int d = 0; d < 6; d++) {
                int nh = h + dh[d];
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nh < 0 || nh >= L || nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                if (building[nh][nr][nc] == '#' || visited[nh][nr][nc]) continue;

                q.push({nh, nr, nc});
                visited[nh][nr][nc] = true;
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
        int l, r, c;
        cin >> l >> r >> c;

        if (l == 0 && r == 0 && c == 0) break;

        memset(building, 0, sizeof(building));
        memset(visited, 0, sizeof(visited));
        Node s, e;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < r; j++) {
                string input;
                cin >> input;

                for (int k = 0; k < c; k++) {
                    building[i][j][k] = input[k];

                    if (building[i][j][k] == 'S') {
                        s = {i, j, k};
                    } else if (building[i][j][k] == 'E') {
                        e = {i, j, k};
                    }
                }
            }
        }

        int dist = bfs(s, e, l, r, c);
        if (dist == -1) {
            cout << "Trapped!\n";
        } else {
            cout << "Escaped in " << dist << " minute(s).\n";
        }
    }
}
