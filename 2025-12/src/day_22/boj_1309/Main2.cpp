#include <bits/stdc++.h>
using namespace std;

constexpr int MOD = 9901;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    int skip = 1;
    int take = 0;

    for (int i = 1; i <= n; i++) {
        int prev = skip;
        skip = (skip + take) % MOD;
        take = (2 * prev + take) % MOD;
    }

    cout << (skip + take) % MOD;
}
