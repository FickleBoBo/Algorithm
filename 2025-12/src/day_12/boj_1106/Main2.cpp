#include <bits/stdc++.h>
using namespace std;

constexpr int MAX = 100000;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int c, n;
    cin >> c >> n;

    vector<pair<int, int>> a(n);
    for (auto& p : a) cin >> p.first >> p.second;

    vector<int> dp(1 + c + 100);
    fill(dp.begin() + 1, dp.end(), MAX);
    for (int i = 0; i < n; i++) {
        int cost = a[i].first;
        int person = a[i].second;

        for (int j = person; j <= c + 100; j++) {
            dp[j] = min(dp[j - person] + cost, dp[j]);
        }
    }

    cout << *min_element(dp.begin() + c, dp.end());
}
