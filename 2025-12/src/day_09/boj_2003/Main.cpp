#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    vector<int> psum(1 + n);
    for (int i = 1; i <= n; i++) {
        psum[i] = psum[i - 1] + v[i - 1];
    }

    int cnt = 0;
    for (int i = 1; i <= n; i++) {
        for (int j = i; j <= n; j++) {
            if (psum[j] - psum[i - 1] == m) cnt++;
        }
    }

    cout << cnt;
}
