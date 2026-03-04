#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;

    while (t--) {
        int n, k;
        cin >> n >> k;

        if (n == 1 && k == 1) {
            cout << 1 << '\n';
        } else if (k != 2) {
            cout << -1 << '\n';
        } else {
            for (int i = 2; i <= n; i++) {
                cout << i << ' ';
            }
            cout << 1 << '\n';
        }
    }
}
