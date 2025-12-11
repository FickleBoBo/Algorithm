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

    vector<int> dp(1 + k);
    fill(dp.begin() + 1, dp.end(), MAX);  // 어떤 동전도 사용하지 않았을 때 0원을 만드는 경우는 사용한 동전은 0개
    for (int coin : coins) {
        for (int j = coin; j <= k; j++) {
            dp[j] = min(dp[j - coin] + 1, dp[j]);
        }
    }

    if (dp[k] == MAX) {
        cout << -1;
    } else {
        cout << dp[k];
    }
}
