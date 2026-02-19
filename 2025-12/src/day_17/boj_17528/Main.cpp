#include <bits/stdc++.h>
using namespace std;

int dp[251][1 + 250 * 250];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<pair<int, int>> v(n);
    for (auto& [a, b] : v) cin >> a >> b;

    int sum = 0;
    for (auto [a, b] : v) sum += a;

    for (int i = 1; i <= n; i++) {
        auto [a, b] = v[i - 1];

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
