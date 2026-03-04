#include <bits/stdc++.h>
using namespace std;

const int MAX = 100;
char grid[101][101];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        cin >> grid[i];
    }

    int cnt = 0;
    string res;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (grid[i][j] == 'O') continue;

            if (i < n - 1 && grid[i + 1][j] == 'X') {
                res += "2 " + to_string(i + 1 + n * j) + " " + to_string(i + 2 + n * j) + "\n";
                grid[i][j] = 'O';
                grid[i + 1][j] = 'O';
            } else if (n == 1 && j < m - 1 && grid[i][j + 1] == 'X') {
                res += "2 " + to_string(i + 1 + n * j) + " " + to_string(i + 1 + n * (j + 1)) + "\n";
                grid[i][j] = 'O';
                grid[i][j + 1] = 'O';
            } else {
                res += "1 " + to_string(i + 1 + n * j) + "\n";
                grid[i][j] = 'O';
            }
            cnt++;
        }
    }

    cout << cnt << '\n';
    cout << res;
}
