#include <algorithm>
#include <queue>
#include <string>
#include <vector>

using namespace std;

int dr[4] = {-1, 0, 1, 0};
int dc[4] = {0, 1, 0, -1};

int bfs(int r, int c, int n, int m, vector<vector<int>>& grid) {
    int sum = 0;

    queue<pair<int, int>> q;
    q.push({r, c});

    sum += grid[r][c];
    grid[r][c] = 0;

    while (!q.empty()) {
        auto [r, c] = q.front();
        q.pop();

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            if (grid[nr][nc] == 0) continue;

            q.push({nr, nc});
            sum += grid[nr][nc];
            grid[nr][nc] = 0;
        }
    }

    return sum;
}

vector<int> solution(vector<string> maps) {
    vector<vector<int>> grid(maps.size(), vector<int>(maps[0].size()));
    for (int i = 0; i < maps.size(); i++) {
        for (int j = 0; j < maps[0].size(); j++) {
            if (maps[i][j] != 'X') {
                grid[i][j] = maps[i][j] - '0';
            }
        }
    }

    vector<int> ans;
    for (int i = 0; i < grid.size(); i++) {
        for (int j = 0; j < grid[i].size(); j++) {
            if (grid[i][j] == 0) continue;

            int res = bfs(i, j, grid.size(), grid[i].size(), grid);
            ans.push_back(res);
        }
    }
    sort(ans.begin(), ans.end());

    if (ans.empty()) {
        return {-1};
    }
    return ans;
}
