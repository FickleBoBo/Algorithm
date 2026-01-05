#include <string>
#include <vector>

using namespace std;

constexpr int MOD = 1000000007;

int solution(int n) {
    if (n == 1) return 1;

    vector<int> dp(1 + n);
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= n; i++) {
        dp[i] = (dp[i - 2] + dp[i - 1]) % MOD;
    }

    return dp[n];
}
