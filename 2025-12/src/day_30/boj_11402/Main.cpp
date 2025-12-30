#include <bits/stdc++.h>
using namespace std;

int dp[1 + 2000][1 + 2000];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    long long n, k;
    int m;
    cin >> n >> k >> m;

    for (int i = 0; i <= m; i++) {
        dp[i][0] = 1;

        for (int j = 1; j <= i; j++) {
            dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % m;
        }
    }

    long long ans = 1;

    // 뤼카의 정리
    while (n > 0) {
        // N, K를 M진법으로 변환시 자릿수
        int ni = (int)(n % m);
        int ki = (int)(k % m);

        if (ni < ki) {
            ans = 0;
            break;
        }

        ans = ans * dp[ni][ki] % m;

        // 다음 자릿수로 이동하는 효과
        n = n / m;
        k = k / m;
    }

    cout << ans;
}
