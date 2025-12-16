#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    vector<pair<int, int>> a(m);
    for (auto& p : a) cin >> p.first >> p.second;

    vector<int> dp(1 + n);
    for (auto p : a) {
        int day = p.first;
        int page = p.second;

        for (int j = n; j >= day; j--) {
            dp[j] = max(dp[j - day] + page, dp[j]);
        }
    }

    cout << dp[n];
}
