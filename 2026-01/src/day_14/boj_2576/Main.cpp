#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int sum = 0;
    int mn = 100;

    for (int i = 0; i < 7; i++) {
        int n;
        cin >> n;

        if (n % 2) {
            sum += n;
            mn = min(mn, n);
        }
    }

    if (sum == 0) {
        cout << -1;
    } else {
        cout << sum << '\n';
        cout << mn << '\n';
    }
}
