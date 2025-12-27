#include <bits/stdc++.h>
using namespace std;

constexpr int MOD = 9901;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<vector<int>> dp(1 + n, vector<int>(2));
    dp[0][0] = 1;

    for (int i = 1; i <= n; i++) {
        dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        dp[i][1] = (2 * dp[i - 1][0] + dp[i - 1][1]) % MOD;
    }

    cout << (dp[n][0] + dp[n][1]) % MOD;
}
