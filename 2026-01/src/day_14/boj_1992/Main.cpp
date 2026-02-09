#include <bits/stdc++.h>
using namespace std;

char grid[64][64];

bool check(int r1, int c1, int r2, int c2) {
    for (int i = r1; i < r2; i++) {
        for (int j = c1; j < c2; j++) {
            if (grid[i][j] != grid[r1][c1]) return false;
        }
    }

    return true;
}

void recur(int r1, int c1, int r2, int c2) {
    if (check(r1, c1, r2, c2)) {
        cout << grid[r1][c1];
    } else {
        cout << '(';

        int mr = (r1 + r2) / 2;
        int mc = (c1 + c2) / 2;

        recur(r1, c1, mr, mc);
        recur(r1, mc, mr, c2);
        recur(mr, c1, r2, mc);
        recur(mr, mc, r2, c2);

        cout << ')';
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> grid[i];
    }

    recur(0, 0, n, n);
}
