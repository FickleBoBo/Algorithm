#include <bits/stdc++.h>
using namespace std;

struct Item {
    int m;
    long long p;  // 점수 계산에서 오버플로우 방지
    int r;
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, t;
    cin >> n >> t;

    vector<Item> items(n);
    for (int i = 0; i < n; i++) cin >> items[i].m;
    for (int i = 0; i < n; i++) cin >> items[i].p;
    for (int i = 0; i < n; i++) cin >> items[i].r;
    sort(items.begin(), items.end(), [](const Item& a, const Item& b) {
        return a.r * b.p < a.p * b.r;
    });

    vector<vector<long long>> dp(1 + n, vector<long long>(1 + t));
    for (int i = 1; i <= n; i++) {
        Item item = items[i - 1];
        int m = item.m;
        long long p = item.p;
        int r = item.r;

        for (int j = 1; j <= t; j++) {
            if (j < r) {
                dp[i][j] = dp[i - 1][j];
            } else {
                dp[i][j] = max(dp[i - 1][j - r] + (m - j * p), dp[i - 1][j]);
            }
        }
    }

    cout << *max_element(dp[n].begin() + 1, dp[n].end());
}
