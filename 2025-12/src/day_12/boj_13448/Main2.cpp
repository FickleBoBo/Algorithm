#include <bits/stdc++.h>
using namespace std;

long long dp[100001];

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
    sort(items.begin(), items.end(), [](Item& a, Item& b) {
        return a.r * b.p < a.p * b.r;
    });

    for (auto [m, p, r] : items) {
        for (int j = t; j >= r; j--) {
            dp[j] = max(dp[j - r] + (m - j * p), dp[j]);
        }
    }

    long long mx = 0;
    for (int j = 1; j <= t; j++) {
        mx = max(mx, dp[j]);
    }

    cout << mx;
}
