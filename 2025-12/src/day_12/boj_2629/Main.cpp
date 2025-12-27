#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> wa(n);
    for (int& x : wa) cin >> x;

    int sum = 0;
    for (int x : wa) sum += x;

    int m;
    cin >> m;

    vector<int> ba(m);
    for (int& x : ba) cin >> x;

    vector<vector<bool>> dp(1 + n, vector<bool>(1 + sum));
    dp[0][0] = true;  // 추가 주어지지 않아도 구슬의 무게가 0이면 측정 가능
    for (int i = 1; i <= n; i++) {
        int w = wa[i - 1];

        for (int j = 0; j <= sum; j++) {
            if (!dp[i - 1][j]) continue;

            dp[i][j] = true;           // 현재 추를 사용하지 않는 경우
            dp[i][j + w] = true;       // 현재 추를 사용하는 경우
            dp[i][abs(j - w)] = true;  // 현재 추를 사용하는 경우
        }
    }

    for (int b : ba) {
        // 구슬의 무게가 모든 추의 무게보다 크거나 추의 조합으로 측정 불가능하면 N
        if (b > sum || !dp[n][b]) {
            cout << "N ";
        } else {
            cout << "Y ";
        }
    }
}
