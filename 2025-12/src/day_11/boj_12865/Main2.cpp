#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;

    vector<pair<int, int>> a(n);
    for (auto& p : a) cin >> p.first >> p.second;

    vector<int> dp(1 + k);
    for (auto p : a) {
        int w = p.first;
        int v = p.second;

        for (int j = k; j >= w; j--) {
            dp[j] = max(dp[j - w] + v, dp[j]);
        }
    }

    cout << dp[k];
}
