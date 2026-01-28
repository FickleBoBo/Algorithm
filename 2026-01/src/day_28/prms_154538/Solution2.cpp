#include <algorithm>
#include <string>
#include <vector>

using namespace std;

constexpr int MAX = 1000000;

int solution(int x, int y, int n) {
    vector<int> dp(1 + y * 3, MAX);
    dp[x] = 0;

    for (int i = x; i <= y; i++) {
        dp[i + n] = min(dp[i + n], dp[i] + 1);
        dp[i * 2] = min(dp[i * 2], dp[i] + 1);
        dp[i * 3] = min(dp[i * 3], dp[i] + 1);
    }

    return dp[y] == MAX ? -1 : dp[y];
}
