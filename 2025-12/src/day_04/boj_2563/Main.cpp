#include <bits/stdc++.h>
using namespace std;

bool visited[100][100];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        int row, col;
        cin >> row >> col;

        for (int r = row; r < row + 10; r++) {
            for (int c = col; c < col + 10; c++) {
                visited[r][c] = true;
            }
        }
    }

    int sum = 0;
    for (int i = 0; i < 100; i++) {
        for (int j = 0; j < 100; j++) {
            if (visited[i][j]) sum++;
        }
    }

    cout << sum;
}
