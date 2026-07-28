#include <algorithm>
#include <string>
#include <vector>

using namespace std;

int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};

int n, m;
bool vis[100][100];

int dfs(int r, int c, vector<string>& maps) {
    vis[r][c] = true;
    int res = maps[r][c] - '0';

    for (int d = 0; d < 4; d++) {
        int nr = r + dr[d];
        int nc = c + dc[d];

        if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
        if (maps[nr][nc] == 'X' || vis[nr][nc]) continue;

        res += dfs(nr, nc, maps);
    }

    return res;
}

vector<int> solution(vector<string> maps) {
    n = maps.size();
    m = maps[0].size();
    vector<int> ans;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (maps[i][j] == 'X' || vis[i][j]) continue;

            int res = dfs(i, j, maps);
            ans.push_back(res);
        }
    }

    if (ans.empty()) return {-1};

    sort(ans.begin(), ans.end());
    return ans;
}
