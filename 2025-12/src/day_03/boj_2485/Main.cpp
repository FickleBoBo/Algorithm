#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    int g = gcd(v[1] - v[0], v[2] - v[1]);
    for (int i = 3; i < n; i++) {
        g = gcd(g, v[i] - v[i - 1]);
    }

    cout << (v[n - 1] - v[0]) / g + 1 - n;
}
