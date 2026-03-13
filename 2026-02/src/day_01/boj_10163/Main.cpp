#include <bits/stdc++.h>
using namespace std;

const int MX = 1001;
int grid[MX][MX];
int cnt[MX];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    for (int i = 1; i <= n; i++) {
        int sr, sc, rlen, clen;
        cin >> sr >> sc >> rlen >> clen;

        for (int r = sr; r < sr + rlen; r++) {
            for (int c = sc; c < sc + clen; c++) {
                grid[r][c] = i;
            }
        }
    }

    for (int i = 0; i < MX; i++) {
        for (int j = 0; j < MX; j++) {
            cnt[grid[i][j]]++;
        }
    }

    for (int i = 1; i <= n; i++) {
        cout << cnt[i] << '\n';
    }
}
