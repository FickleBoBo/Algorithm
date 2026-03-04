#include <bits/stdc++.h>
using namespace std;

int dr[8] = {-1, -1, -1, 0, 1, 1, 1, 0};
int dc[8] = {-1, 0, 1, 1, 1, 0, -1, -1};
char grid[9][9];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    for (int i = 0; i < 8; i++) {
        cin >> grid[i];
    }

    vector<pair<int, int>> v;
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            if (grid[i][j] == '*') v.push_back({i, j});
        }
    }

    if (v.size() != 8) {
        cout << "invalid";
        return 0;
    }

    for (auto [r, c] : v) {
        for (int d = 0; d < 8; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            while (nr >= 0 && nr < 8 && nc >= 0 && nc < 8) {
                if (grid[nr][nc] == '*') {
                    cout << "invalid";
                    return 0;
                }
                nr += dr[d];
                nc += dc[d];
            }
        }
    }

    cout << "valid";
    return 0;
}
