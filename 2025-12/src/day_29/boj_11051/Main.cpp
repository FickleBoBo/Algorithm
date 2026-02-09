#include <bits/stdc++.h>
using namespace std;

constexpr int MOD = 10007;
int dp[1001][1001];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;

    for (int i = 0; i <= n; i++) {
        dp[i][0] = 1;

        for (int j = 1; j <= min(i, k); j++) {
            dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % MOD;
        }
    }

    cout << dp[n][k];
}
