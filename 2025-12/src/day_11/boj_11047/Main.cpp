#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;

    vector<int> coins(n);
    for (int& x : coins) cin >> x;

    int cnt = 0;
    for (int i = n - 1; i >= 0; i--) {
        if (coins[i] <= k) {
            cnt += k / coins[i];
            k %= coins[i];
        }
    }

    cout << cnt;
}
