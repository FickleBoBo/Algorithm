#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;

    for (int tc = 1; tc <= t; tc++) {
        int n;
        cin >> n;

        vector<pair<int, int>> v(n);
        for (auto& p : v) cin >> p.first >> p.second;

        int sum = 0;
        for (auto p : v) sum += p.first;

        vector<vector<int>> dp(2, vector<int>(1 + sum));  // 롤링 배열
        int prev = 0;
        int cur = 1;
        for (int i = 0; i < n; i++) {
            int a = v[i].first;
            int b = v[i].second;

            for (int j = 0; j <= sum; j++) {
                if (j < a) {
                    dp[cur][j] = dp[prev][j] + b;
                } else {
                    dp[cur][j] = min(dp[prev][j - a], dp[prev][j] + b);
                }
            }

            // 롤링
            prev ^= 1;
            cur ^= 1;
        }

        int mn = INT_MAX;
        for (int j = 0; j <= sum; j++) {
            mn = min(mn, max(j, dp[prev][j]));  // 롤링 때문에 최신값이 prev에 있음
        }

        cout << mn << '\n';
    }
}
