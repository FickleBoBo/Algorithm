#include <bits/stdc++.h>
using namespace std;

int dp[21][201];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    vector<pair<int, int>> a(m);
    for (auto& [day, page] : a) cin >> day >> page;

    for (int i = 1; i <= m; i++) {
        auto [day, page] = a[i - 1];

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
