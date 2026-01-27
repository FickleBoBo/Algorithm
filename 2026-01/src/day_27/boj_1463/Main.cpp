#include <bits/stdc++.h>
using namespace std;

constexpr int MAX = 100000;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> dp(1 + n * 3, MAX);
    dp[1] = 0;

    for (int i = 1; i <= n; i++) {
        dp[i * 3] = min(dp[i * 3], dp[i] + 1);
        dp[i * 2] = min(dp[i * 2], dp[i] + 1);
        dp[i + 1] = min(dp[i + 1], dp[i] + 1);
    }

    cout << dp[n];
}
