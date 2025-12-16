#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<pair<int, int>> v(n);
    for (auto& p : v) cin >> p.first >> p.second;

    int sum = 0;
    for (auto p : v) sum += p.first;

    vector<int> dp(1 + sum);
    for (auto p : v) {
        int a = p.first;
        int b = p.second;

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

    cout << mn;
}
