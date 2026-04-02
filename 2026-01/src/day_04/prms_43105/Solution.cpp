#include <algorithm>
#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> triangle) {
    int len = triangle.size();

    vector<vector<int>> dp(1 + len, vector<int>(1 + len));
    for (int i = 1; i <= len; i++) {
        for (int j = 1; j <= i; j++) {
            dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i - 1][j - 1];
        }
    }

    return *max_element(dp[len].begin(), dp[len].end());
}
