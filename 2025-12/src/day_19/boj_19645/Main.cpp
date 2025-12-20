#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    int sum = 0;
    for (int x : v) sum += x;

    vector<vector<bool>> dp(1 + sum, vector<bool>(1 + sum));
    dp[0][0] = true;  // 세 명 다 어떤 햄버거도 먹지 않았음
    for (int x : v) {
        for (int i = sum; i >= 0; i--) {
            for (int j = sum; j >= 0; j--) {
                if (dp[i][j]) {
                    dp[i + x][j] = true;
                    dp[i][j + x] = true;
                }
            }
        }
    }

    int mx = 0;
    for (int i = 1; i <= sum; i++) {
        for (int j = i; j <= sum; j++) {
            if (dp[i][j] && (sum - i - j) <= i) {
                mx = max(mx, sum - i - j);
            }
        }
    }

    cout << mx;
}
