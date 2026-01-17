#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> v(6);
    for (int& x : v) cin >> x;

    int t, p;
    cin >> t >> p;

    int cnt = 0;
    for (int x : v) {
        cnt += (x + t - 1) / t;
    }

    cout << cnt << '\n';
    cout << n / p << ' ' << n % p;
}
