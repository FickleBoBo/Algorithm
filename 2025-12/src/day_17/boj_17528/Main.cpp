#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<pair<int, int>> v(n);
    for (auto& p : v) cin >> p.first >> p.second;

    int sum = 0;
    for (auto p : v) sum += p.first;

    vector<vector<int>> dp(1 + n, vector<int>(1 + sum));
    for (int i = 1; i <= n; i++) {
        int a = v[i - 1].first;
        int b = v[i - 1].second;

        for (int j = 0; j <= sum; j++) {
            if (j < a) {
                dp[i][j] = dp[i - 1][j] + b;
            } else {
                dp[i][j] = min(dp[i - 1][j - a], dp[i - 1][j] + b);
            }
        }
    }

    int mn = INT_MAX;
    for (int j = 0; j <= sum; j++) {
        mn = min(mn, max(j, dp[n][j]));
    }

    cout << mn;
}
