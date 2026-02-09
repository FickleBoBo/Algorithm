#include <bits/stdc++.h>
using namespace std;

constexpr int MOD = 10007;
int dp[1001] = {0, 1, 3};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    for (int i = 3; i <= n; i++) {
        dp[i] = (2 * dp[i - 2] + dp[i - 1]) % MOD;
    }

    cout << dp[n];
}
