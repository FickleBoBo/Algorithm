#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;

    for (int tc = 1; tc <= t; tc++) {
        int x, n;
        cin >> x >> n;

        if (n % 2 == 0) {
            cout << '0' << '\n';
        } else {
            cout << x << '\n';
        }
    }
}
