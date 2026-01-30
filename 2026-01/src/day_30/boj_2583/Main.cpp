#include <bits/stdc++.h>
using namespace std;

int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};

int n, m, k;
bool grid[100][100];

int bfs(int sr, int sc) {
    queue<pair<int, int>> q;
    q.push({sr, sc});

    grid[sr][sc] = true;

    int cnt = 1;

    while (!q.empty()) {
        auto [r, c] = q.front();
        q.pop();

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            if (grid[nr][nc]) continue;

            q.push({nr, nc});
            grid[nr][nc] = true;
            cnt++;
        }
    }

    return cnt;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> m >> n >> k;

    for (int i = 0; i < k; i++) {
        int sr, sc, er, ec;
        cin >> sr >> sc >> er >> ec;

        for (int r = sr; r < er; r++) {
            for (int c = sc; c < ec; c++) {
                grid[r][c] = true;
            }
        }
    }

    int cnt = 0;
    vector<int> v;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (!grid[i][j]) {
                int res = bfs(i, j);
                cnt++;
                v.push_back(res);
            }
        }
    }
    sort(v.begin(), v.end());

    cout << cnt << '\n';
    for (int x : v) {
        cout << x << ' ';
    }
}
