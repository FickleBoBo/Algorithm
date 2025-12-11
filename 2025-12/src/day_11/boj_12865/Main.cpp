#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;

    vector<pair<int, int>> a(n);
    for (auto& p : a) cin >> p.first >> p.second;

    vector<vector<int>> dp(1 + n, vector<int>(1 + k));
    for (int i = 1; i <= n; i++) {
        int w = a[i - 1].first;
        int v = a[i - 1].second;

        for (int j = 1; j <= k; j++) {
            if (j < w) {
                dp[i][j] = dp[i - 1][j];
            } else {
                dp[i][j] = max(dp[i - 1][j - w] + v, dp[i - 1][j]);
            }
        }
    }

    cout << dp[n][k];
}
