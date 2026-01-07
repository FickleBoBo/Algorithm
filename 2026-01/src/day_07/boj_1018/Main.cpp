#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    vector<string> v(n);
    for (string& x : v) cin >> x;

    int mn = 32;

    for (int r = 0; r <= n - 8; r++) {
        for (int c = 0; c <= m - 8; c++) {
            int isWhite = 0;  // 맨 왼쪽 위 칸을 흰색으로 둘 경우
            int isBlack = 0;  // 맨 왼쪽 위 칸을 검은색으로 둘 경우

            for (int i = r; i < r + 8; i++) {
                for (int j = c; j < c + 8; j++) {
                    if ((i + j) % 2 == 0) {
                        if (v[i][j] == 'B') {
                            isWhite++;
                        } else {
                            isBlack++;
                        }
                    } else {
                        if (v[i][j] == 'W') {
                            isWhite++;
                        } else {
                            isBlack++;
                        }
                    }
                }
            }

            mn = min(mn, min(isWhite, isBlack));
        }
    }

    cout << mn;
}
