#include <string>
#include <vector>

using namespace std;

constexpr int MOD = 1000000007;
int dp[60001] = {0, 1, 2};

int solution(int n) {
    for (int i = 3; i <= n; i++) {
        dp[i] = (dp[i - 2] + dp[i - 1]) % MOD;
    }

    return dp[n];
}
