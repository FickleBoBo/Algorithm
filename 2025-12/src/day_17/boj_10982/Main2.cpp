#include <bits/stdc++.h>
using namespace std;

int dp[100001];

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
        for (auto [a, b] : v) {
            for (int j = sum; j >= 0; j--) {
                if (j < a) {
                    dp[j] += b;
                } else {
                    dp[j] = min(dp[j - a], dp[j] + b);
                }
            }
        }

        int mn = INT_MAX;
        for (int j = 0; j <= sum; j++) {
            mn = min(mn, max(j, dp[j]));
        }

        cout << mn << '\n';
    }
}
