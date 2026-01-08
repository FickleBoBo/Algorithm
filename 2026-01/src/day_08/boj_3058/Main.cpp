#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;

    for (int tc = 1; tc <= t; tc++) {
        int sum = 0;
        int mn = 100;

        for (int i = 0; i < 7; i++) {
            int x;
            cin >> x;

            if (x % 2 == 0) {
                sum += x;
                mn = min(mn, x);
            }
        }

        cout << sum << ' ' << mn << '\n';
    }
}
