#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    for (int i = 1; i <= n; i++) {
        int x = i;
        int sum = x;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }

        if (sum == n) {
            cout << i;
            return 0;
        }
    }

    cout << 0;
}
