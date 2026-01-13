#include <bits/stdc++.h>
using namespace std;

int board[128][128];
int cntArr[2];

bool check(int r1, int c1, int r2, int c2) {
    for (int i = r1; i < r2; i++) {
        for (int j = c1; j < c2; j++) {
            if (board[i][j] != board[r1][c1]) return false;
        }
    }

    return true;
}

void recur(int r1, int c1, int r2, int c2) {
    if (check(r1, c1, r2, c2)) {
        cntArr[board[r1][c1]]++;
    } else {
        int mr = (r1 + r2) / 2;
        int mc = (c1 + c2) / 2;

        recur(r1, c1, mr, mc);
        recur(r1, mc, mr, c2);
        recur(mr, c1, r2, mc);
        recur(mr, mc, r2, c2);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> board[i][j];
        }
    }

    recur(0, 0, n, n);

    cout << cntArr[0] << '\n';
    cout << cntArr[1] << '\n';
}
