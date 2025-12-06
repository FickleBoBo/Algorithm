#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int mx = -1;
    int row = 0;
    int col = 0;

    for (int i = 1; i <= 9; i++) {
        for (int j = 1; j <= 9; j++) {
            int n;
            cin >> n;

            if (n > mx) {
                mx = n;
                row = i;
                col = j;
            }
        }
    }

    cout << mx << '\n';
    cout << row << ' ' << col;
}
