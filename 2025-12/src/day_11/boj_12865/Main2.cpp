#include <bits/stdc++.h>
using namespace std;

int dp[100001];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;

    vector<pair<int, int>> a(n);
    for (auto& [w, v] : a) cin >> w >> v;

    for (auto [w, v] : a) {
        for (int j = k; j >= w; j--) {
            dp[j] = max(dp[j - w] + v, dp[j]);
        }
    }

    cout << dp[k];
}
