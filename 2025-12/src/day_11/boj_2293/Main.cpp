#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;

    vector<int> coins(n);
    for (int& x : coins) cin >> x;

    vector<vector<int>> dp(2, vector<int>(1 + k));  // 토글링 dp
    int prev = 0;
    int cur = 1;
    dp[0][0] = 1;  // 어떤 동전도 사용하지 않았을 때 0원을 만드는 경우는 1가지
    for (int coin : coins) {
        for (int j = 0; j <= k; j++) {
            if (j < coin) {
                dp[cur][j] = dp[prev][j];
            } else {
                dp[cur][j] = dp[prev][j] + dp[cur][j - coin];
            }
        }

        // 토글링
        prev ^= 1;
        cur ^= 1;
    }

    cout << dp[prev][k];
}
