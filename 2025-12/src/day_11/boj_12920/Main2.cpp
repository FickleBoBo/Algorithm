#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    vector<pair<int, int>> a;
    for (int i = 0; i < n; i++) {
        int v, c, k;
        cin >> v >> c >> k;

        // 이진 그룹핑
        for (int bit = 1; bit <= k; bit <<= 1) {
            a.emplace_back(v * bit, c * bit);
            k -= bit;
        }

        // 나머지가 존재하면 그룹핑
        if (k) {
            a.emplace_back(v * k, c * k);
        }
    }

    vector<int> dp(1 + m);
    for (auto p : a) {
        int v = p.first;
        int c = p.second;

        for (int j = m; j >= v; j--) {
            dp[j] = max(dp[j - v] + c, dp[j]);
        }
    }

    cout << dp[m];
}
