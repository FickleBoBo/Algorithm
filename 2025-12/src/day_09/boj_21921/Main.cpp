#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, x;
    cin >> n >> x;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    vector<int> psum(1 + n);
    for (int i = 1; i <= n; i++) {
        psum[i] = psum[i - 1] + v[i - 1];
    }

    int mx = 0;
    int cnt = 0;
    for (int i = 0; i <= n - x; i++) {
        int diff = psum[i + x] - psum[i];

        if (diff > mx) {
            mx = diff;
            cnt = 1;
        } else if (diff == mx) {
            cnt++;
        }
    }

    if (mx == 0) {
        cout << "SAD";
    } else {
        cout << mx << '\n';
        cout << cnt << '\n';
    }
}
