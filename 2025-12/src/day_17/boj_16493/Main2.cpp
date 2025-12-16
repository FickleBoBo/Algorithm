#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    vector<pair<int, int>> a(m);
    for (auto& p : a) cin >> p.first >> p.second;

    vector<vector<int>> dp(1 + m, vector<int>(1 + n));
    for (int i = 1; i <= m; i++) {
        int day = a[i - 1].first;
        int page = a[i - 1].second;

        for (int j = 1; j <= n; j++) {
            if (j < day) {
                dp[i][j] = dp[i - 1][j];
            } else {
                dp[i][j] = max(dp[i - 1][j - day] + +page, dp[i - 1][j]);
            }
        }
    }

    cout << dp[m][n];
}
