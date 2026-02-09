#include <bits/stdc++.h>
using namespace std;

int dp[30][30];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    for (int i = 0; i < 30; i++) {
        dp[i][0] = 1;

        for (int j = 1; j <= i; j++) {
            dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
        }
    }

    int t;
    cin >> t;

    while (t--) {
        int n, m;
        cin >> n >> m;
        cout << dp[m][n] << '\n';
    }
}
