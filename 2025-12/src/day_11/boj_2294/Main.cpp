#include <bits/stdc++.h>
using namespace std;

constexpr int MAX = 10001;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;

    vector<int> coins(n);
    for (int& x : coins) cin >> x;

    vector<vector<int>> dp(1 + n, vector<int>(1 + k));
    fill(dp[0].begin() + 1, dp[0].end(), MAX);  // 어떤 동전도 사용하지 않았을 때 0원을 만드는 경우는 사용한 동전은 0개
    for (int i = 1; i <= n; i++) {
        int coin = coins[i - 1];

        for (int j = 1; j <= k; j++) {
            if (j < coin) {
                dp[i][j] = dp[i - 1][j];
            } else {
                dp[i][j] = min(dp[i][j - coin] + 1, dp[i - 1][j]);
            }
        }
    }

    if (dp[n][k] == MAX) {
        cout << -1;
    } else {
        cout << dp[n][k];
    }
}
