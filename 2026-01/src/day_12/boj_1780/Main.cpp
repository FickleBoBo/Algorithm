#include <bits/stdc++.h>
using namespace std;

int board[2187][2187];
int cntArr[3];

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
        cntArr[board[r1][c1] + 1]++;
    } else {
        int mr1 = r1 + (r2 - r1) / 3;
        int mc1 = c1 + (c2 - c1) / 3;
        int mr2 = r1 + (r2 - r1) / 3 * 2;
        int mc2 = c1 + (c2 - c1) / 3 * 2;

        recur(r1, c1, mr1, mc1);
        recur(r1, mc1, mr1, mc2);
        recur(r1, mc2, mr1, c2);
        recur(mr1, c1, mr2, mc1);
        recur(mr1, mc1, mr2, mc2);
        recur(mr1, mc2, mr2, c2);
        recur(mr2, c1, r2, mc1);
        recur(mr2, mc1, r2, mc2);
        recur(mr2, mc2, r2, c2);
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
    cout << cntArr[2] << '\n';
}
