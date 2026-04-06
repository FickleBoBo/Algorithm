#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    int ans = 0;
    for (int i = n - 2; i >= 0; i--) {
        if (v[i] >= v[i + 1]) {
            ans += v[i] - v[i + 1] + 1;
            v[i] = v[i + 1] - 1;
        }
    }

    cout << ans;
}
