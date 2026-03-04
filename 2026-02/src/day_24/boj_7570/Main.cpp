#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    vector<int> dp(1 + n);
    for (int x : v) {
        dp[x] = dp[x - 1] + 1;
    }

    cout << n - *max_element(dp.begin(), dp.end());
}
