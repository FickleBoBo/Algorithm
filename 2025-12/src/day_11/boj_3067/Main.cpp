#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;

    for (int tc = 1; tc <= t; tc++) {
        int n;
        cin >> n;

        vector<int> coins(n);
        for (int& x : coins) cin >> x;

        int m;
        cin >> m;

        vector<vector<int>> dp(1 + n, vector<int>(1 + m));
        dp[0][0] = 1;  // 어떤 동전도 사용하지 않았을 때 0원을 만드는 경우는 1가지
        for (int i = 1; i <= n; i++) {
            int coin = coins[i - 1];

            for (int j = 0; j <= m; j++) {
                if (j < coin) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coin];
                }
            }
        }

        cout << dp[n][m] << '\n';
    }
}
