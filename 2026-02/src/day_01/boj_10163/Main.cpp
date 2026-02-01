#include <bits/stdc++.h>
using namespace std;

int MAXN = 1001;
int grid[1001][1001];
int cntArr[1001];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

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

    for (int i = 0; i < MAXN; i++) {
        for (int j = 0; j < MAXN; j++) {
            cntArr[grid[i][j]]++;
        }
    }

    for (int i = 1; i <= n; i++) {
        cout << cntArr[i] << '\n';
    }
}
