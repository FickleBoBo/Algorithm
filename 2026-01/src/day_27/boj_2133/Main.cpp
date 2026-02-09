#include <bits/stdc++.h>
using namespace std;

int dp[31] = {0, 0, 3};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    if (n % 2) {
        cout << 0;
        return 0;
    }

    for (int i = 4; i <= n; i += 2) {
        dp[i] += dp[i - 2] * 3 + 2;

        for (int j = i - 4; j >= 2; j -= 2) {
            dp[i] += dp[j] * 2;
        }
    }

    cout << dp[n];
}
