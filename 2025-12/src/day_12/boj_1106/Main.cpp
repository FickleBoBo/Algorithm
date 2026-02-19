#include <bits/stdc++.h>
using namespace std;

constexpr int MAX = 100000;
int dp[21][1101];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int c, n;
    cin >> c >> n;

    vector<pair<int, int>> a(n);
    for (auto& [cost, person] : a) cin >> cost >> person;

    fill(dp[0] + 1, dp[0] + 1101, MAX);
    for (int i = 1; i <= n; i++) {
        auto [cost, person] = a[i - 1];

        for (int j = 1; j <= c + 100; j++) {
            if (j < person) {
                dp[i][j] = dp[i - 1][j];
            } else {
                dp[i][j] = min(dp[i][j - person] + cost, dp[i - 1][j]);
            }
        }
    }

    int mn = MAX;
    for (int j = c; j <= c + 100; j++) {
        mn = min(mn, dp[n][j]);
    }

    cout << mn;
}
