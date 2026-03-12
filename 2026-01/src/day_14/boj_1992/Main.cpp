#include <bits/stdc++.h>
using namespace std;

char grid[65][65];

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
        cout << grid[sr][sc];
    } else {
        cout << '(';

        int mr = (sr + er) / 2;
        int mc = (sc + ec) / 2;

        dfs(sr, sc, mr, mc);
        dfs(sr, mc, mr, ec);
        dfs(mr, sc, er, mc);
        dfs(mr, mc, er, ec);

        cout << ')';
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> grid[i];
    }

    dfs(0, 0, n, n);
}
