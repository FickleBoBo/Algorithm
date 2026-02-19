#include <bits/stdc++.h>
using namespace std;

constexpr int MAX = 100000;
int dp[1101];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int c, n;
    cin >> c >> n;

    vector<pair<int, int>> a(n);
    for (auto& [cost, person] : a) cin >> cost >> person;

    fill(dp + 1, dp + 1101, MAX);
    for (auto [cost, person] : a) {
        for (int j = person; j <= c + 100; j++) {
            dp[j] = min(dp[j - person] + cost, dp[j]);
        }
    }

    int mn = MAX;
    for (int j = c; j <= c + 100; j++) {
        mn = min(mn, dp[j]);
    }

    cout << mn;
}
