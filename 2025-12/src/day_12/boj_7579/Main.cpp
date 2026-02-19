#include <bits/stdc++.h>
using namespace std;

int dp[101][10001];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    vector<int> ma(n);
    for (int& x : ma) cin >> x;

    vector<int> ca(n);
    for (int& x : ca) cin >> x;

    int sum = 0;
    for (int x : ca) sum += x;

    for (int i = 1; i <= n; i++) {
        int mi = ma[i - 1];
        int ci = ca[i - 1];

        for (int j = 0; j <= sum; j++) {
            if (j < ci) {
                dp[i][j] = dp[i - 1][j];
            } else {
                dp[i][j] = max(dp[i - 1][j - ci] + mi, dp[i - 1][j]);
            }
        }
    }

    for (int j = 0; j <= sum; j++) {
        if (dp[n][j] >= m) {
            cout << j;
            return 0;
        }
    }
}
