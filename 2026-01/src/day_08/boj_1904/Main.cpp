#include <bits/stdc++.h>
using namespace std;

constexpr int MOD = 15746;
int dp[1000001] = {0, 1, 2};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    for (int i = 3; i <= n; i++) {
        dp[i] = (dp[i - 2] + dp[i - 1]) % MOD;
    }

    cout << dp[n];
}
