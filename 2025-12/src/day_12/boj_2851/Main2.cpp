#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    vector<int> v(10);
    for (int& x : v) cin >> x;

    vector<int> psum(1 + 10);
    for (int i = 1; i <= 10; i++) {
        psum[i] = psum[i - 1] + v[i - 1];
    }

    int ans = 0;
    int diff = 1000;
    for (int i = 1; i <= 10; i++) {
        if (abs(psum[i] - 100) <= diff) {
            ans = psum[i];
            diff = abs(psum[i] - 100);
        }
    }

    cout << ans;
}
