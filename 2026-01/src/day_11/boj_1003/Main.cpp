#include <bits/stdc++.h>
using namespace std;

int dp[41][2] = {{1, 0}, {0, 1}};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    for (int i = 2; i < 41; i++) {
        dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
        dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
    }

    int t;
    cin >> t;

    while (t--) {
        int n;
        cin >> n;
        cout << dp[n][0] << ' ' << dp[n][1] << '\n';
    }
}
