#include <bits/stdc++.h>
using namespace std;

int dr[8] = {-2, -2, -1, 1, 2, 2, 1, -1};
int dc[8] = {-1, 1, 2, 2, 1, -1, -2, -2};
int n;
bool vis[300][300];

int bfs(int sr, int sc, int er, int ec) {
    queue<pair<int, int>> q;
    q.push({sr, sc});

    vis[sr][sc] = true;

    int dist = 0;

    while (!q.empty()) {
        int sz = q.size();

        while (sz--) {
            auto [r, c] = q.front();
            q.pop();

            if (r == er && c == ec) return dist;

            for (int d = 0; d < 8; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (vis[nr][nc]) continue;

                q.push({nr, nc});
                vis[nr][nc] = true;
            }
        }

        dist++;
    }

    return -1;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;

    while (t--) {
        int sr, sc, er, ec;
        cin >> n >> sr >> sc >> er >> ec;

        memset(vis, 0, sizeof(vis));

        cout << bfs(sr, sc, er, ec) << '\n';
    }
}
