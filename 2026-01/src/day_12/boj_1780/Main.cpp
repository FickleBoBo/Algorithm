#include <bits/stdc++.h>
using namespace std;

int grid[2187][2187];
int cnt[3];

bool check(int sr, int sc, int er, int ec) {
    for (int r = sr; r < er; r++) {
        for (int c = sc; c < ec; c++) {
            if (grid[r][c] != grid[sr][sc]) return false;
        }
    }

    return true;
}

void dfs(int sr, int sc, int er, int ec) {
    if (check(sr, sc, er, ec)) {
        cnt[grid[sr][sc] + 1]++;
    } else {
        int mr1 = sr + (er - sr) / 3;
        int mc1 = sc + (ec - sc) / 3;
        int mr2 = sr + (er - sr) / 3 * 2;
        int mc2 = sc + (ec - sc) / 3 * 2;

        dfs(sr, sc, mr1, mc1);
        dfs(sr, mc1, mr1, mc2);
        dfs(sr, mc2, mr1, ec);
        dfs(mr1, sc, mr2, mc1);
        dfs(mr1, mc1, mr2, mc2);
        dfs(mr1, mc2, mr2, ec);
        dfs(mr2, sc, er, mc1);
        dfs(mr2, mc1, er, mc2);
        dfs(mr2, mc2, er, ec);
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> grid[i][j];
        }
    }

    dfs(0, 0, n, n);

    cout << cnt[0] << '\n';
    cout << cnt[1] << '\n';
    cout << cnt[2] << '\n';
}
