#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    vector<int> v(n);
    for (auto& num : v) cin >> num;

    vector<long long> psum(1 + n);
    for (int i = 1; i <= n; i++) {
        psum[i] = psum[i - 1] + v[i - 1];
    }

    long long mx = 0;
    for (int i = 0; i <= n - m; i++) {
        mx = max(mx, psum[i + m] - psum[i]);
    }

    cout << mx;
}
