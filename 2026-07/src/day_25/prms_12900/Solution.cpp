#include <bits/stdc++.h>
using namespace std;

const int MOD = 1'000'000'007;
int dp[1 + 60000] = {0, 1, 2};

int solution(int n) {
    for (int i = 3; i <= n; i++) {
        dp[i] = (dp[i - 2] + dp[i - 1]) % MOD;
    }

    return dp[n];
}
