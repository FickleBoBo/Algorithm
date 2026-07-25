#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, k;
    cin >> n >> k;

    if (n == 1 && k == 2) {
        cout << -1;
    } else if (k == 0) {
        for (int i = 0; i < n; i++) {
            cout << 0 << ' ';
        }
    } else {
        for (int i = 0; i <= k - 2; i++) {
            cout << i << ' ';
        }

        for (int i = k + 1; i <= n + 1; i++) {
            cout << k << ' ';
        }
    }
}
