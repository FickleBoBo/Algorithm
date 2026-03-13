#include <bits/stdc++.h>
using namespace std;

bool vis[100][100];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    while (n--) {
        int row, col;
        cin >> row >> col;

        for (int r = row; r < row + 10; r++) {
            for (int c = col; c < col + 10; c++) {
                vis[r][c] = true;
            }
        }
    }

    int sum = 0;
    for (int i = 0; i < 100; i++) {
        for (int j = 0; j < 100; j++) {
            if (vis[i][j]) sum++;
        }
    }

    cout << sum;
}
