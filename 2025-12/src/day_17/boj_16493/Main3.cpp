#include <bits/stdc++.h>
using namespace std;

int dp[201];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    vector<pair<int, int>> a(m);
    for (auto& [day, page] : a) cin >> day >> page;

    for (auto [day, page] : a) {
        for (int j = n; j >= day; j--) {
            dp[j] = max(dp[j - day] + page, dp[j]);
        }
    }

    cout << dp[n];
}
