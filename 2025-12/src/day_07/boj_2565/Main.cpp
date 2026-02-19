#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<pair<int, int>> v(n);
    for (auto& [a, b] : v) cin >> a >> b;
    sort(v.begin(), v.end());

    vector<int> dp(n, 1);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (v[i].second > v[j].second) dp[i] = max(dp[i], dp[j] + 1);
        }
    }

    cout << n - *max_element(dp.begin(), dp.end());
}
