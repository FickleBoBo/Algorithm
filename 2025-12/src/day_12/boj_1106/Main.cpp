#include <bits/stdc++.h>
using namespace std;

constexpr int MAX = 100000;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int c, n;
    cin >> c >> n;

    vector<pair<int, int>> a(n);
    for (auto& p : a) cin >> p.first >> p.second;

    vector<vector<int>> dp(1 + n, vector<int>(1 + c + 100));
    fill(dp[0].begin() + 1, dp[0].end(), MAX);
    for (int i = 1; i <= n; i++) {
        int cost = a[i - 1].first;
        int person = a[i - 1].second;

        for (int j = 1; j <= c + 100; j++) {
            if (j < person) {
                dp[i][j] = dp[i - 1][j];
            } else {
                dp[i][j] = min(dp[i][j - person] + cost, dp[i - 1][j]);
            }
        }
    }

    cout << *min_element(dp[n].begin() + c, dp[n].end());
}
