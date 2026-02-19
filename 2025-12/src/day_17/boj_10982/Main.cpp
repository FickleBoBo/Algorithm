#include <bits/stdc++.h>
using namespace std;

int dp[2][100001];  // 롤링 배열

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;

    while (t--) {
        int n;
        cin >> n;

        vector<pair<int, int>> v(n);
        for (auto& [a, b] : v) cin >> a >> b;

        int sum = 0;
        for (auto [a, b] : v) sum += a;

        memset(dp, 0, sizeof(dp));
        int prev = 0;
        int cur = 1;
        for (auto [a, b] : v) {
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
