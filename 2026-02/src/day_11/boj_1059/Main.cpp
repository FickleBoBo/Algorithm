#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int l;
    cin >> l;

    vector<int> v(l);
    for (int& x : v) cin >> x;

    int n;
    cin >> n;

    int mn = 0;
    int mx = 1001;
    for (int x : v) {
        if (x <= n) mn = max(mn, x);
        if (x >= n) mx = min(mx, x);
    }

    cout << max((n - mn) * (mx - n) - 1, 0);
}
