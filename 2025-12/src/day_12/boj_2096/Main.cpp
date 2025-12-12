#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> mx_dp(3);
    vector<int> mn_dp(3);
    vector<int> tmp(3);  // 계산값 임시저장용 배열

    for (int i = 0; i < n; i++) {
        int x1, x2, x3;
        cin >> x1 >> x2 >> x3;

        // 최대 점수 계산
        tmp[0] = max(mx_dp[0], mx_dp[1]) + x1;
        tmp[1] = max({mx_dp[0], mx_dp[1], mx_dp[2]}) + x2;
        tmp[2] = max(mx_dp[1], mx_dp[2]) + x3;

        mx_dp[0] = tmp[0];
        mx_dp[1] = tmp[1];
        mx_dp[2] = tmp[2];

        // 최소 점수 계산
        tmp[0] = min(mn_dp[0], mn_dp[1]) + x1;
        tmp[1] = min({mn_dp[0], mn_dp[1], mn_dp[2]}) + x2;
        tmp[2] = min(mn_dp[1], mn_dp[2]) + x3;

        mn_dp[0] = tmp[0];
        mn_dp[1] = tmp[1];
        mn_dp[2] = tmp[2];
    }

    cout << max({mx_dp[0], mx_dp[1], mx_dp[2]}) << ' ' << min({mn_dp[0], mn_dp[1], mn_dp[2]});
}
