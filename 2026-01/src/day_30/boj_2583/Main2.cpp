#include <bits/stdc++.h>
using namespace std;

int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};
int n, m;
bool grid[100][100];

int dfs(int r, int c) {
    grid[r][c] = true;
    int cnt = 1;

    for (int d = 0; d < 4; d++) {
        int nr = r + dr[d];
        int nc = c + dc[d];

        if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
        if (grid[nr][nc]) continue;

        cnt += dfs(nr, nc);
    }

    return cnt;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int k;
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
                cnt++;
                v.push_back(dfs(i, j));
            }
        }
    }
    sort(v.begin(), v.end());

    cout << cnt << '\n';
    for (int x : v) {
        cout << x << ' ';
    }
}
