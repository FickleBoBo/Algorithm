#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;

    vector<int> coins(n);
    for (int& x : coins) cin >> x;

    vector<int> dp(1 + k);
    dp[0] = 1;  // 어떤 동전도 사용하지 않았을 때 0원을 만드는 경우는 1가지
    for (int coin : coins) {
        for (int j = coin; j <= k; j++) {
            dp[j] += dp[j - coin];
        }
    }

    cout << dp[k];
}
