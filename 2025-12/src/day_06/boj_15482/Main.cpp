#include <bits/stdc++.h>
using namespace std;

int dp[3003][3003];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string s1, s2;
    cin >> s1 >> s2;

    int n = s1.size();
    int m = s2.size();

    for (int i = 3; i <= n; i += 3) {
        for (int j = 3; j <= m; j += 3) {
            if (s1[i - 3] == s2[j - 3] && s1[i - 2] == s2[j - 2] && s1[i - 1] == s2[j - 1]) {
                dp[i][j] = dp[i - 3][j - 3] + 1;
            } else {
                dp[i][j] = max(dp[i - 3][j], dp[i][j - 3]);
            }
        }
    }

    cout << dp[n][m];
}
