#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;

    for (int tc = 1; tc <= t; tc++) {
        int sumY = 0;
        int sumK = 0;

        for (int i = 0; i < 9; i++) {
            int y, k;
            cin >> y >> k;
            sumY += y;
            sumK += k;
        }

        if (sumY > sumK) {
            cout << "Yonsei\n";
        } else if (sumY < sumK) {
            cout << "Korea\n";
        } else {
            cout << "Draw\n";
        }
    }
}
