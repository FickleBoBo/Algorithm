#include <bits/stdc++.h>
using namespace std;

int dp[10001];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;

    while (t--) {
        int n;
        cin >> n;

        vector<int> coins(n);
        for (int& x : coins) cin >> x;

        int m;
        cin >> m;

        memset(dp, 0, sizeof(dp));
        dp[0] = 1;  // 어떤 동전도 사용하지 않았을 때 0원을 만드는 경우는 1가지
        for (int coin : coins) {
            for (int j = coin; j <= m; j++) {
                dp[j] += dp[j - coin];
            }
        }

        cout << dp[m] << '\n';
    }
}
