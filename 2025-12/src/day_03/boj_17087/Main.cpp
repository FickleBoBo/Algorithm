#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, s;
    cin >> n >> s;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    int g = abs(s - v[0]);
    for (int i = 1; i < n; i++) {
        g = gcd(g, abs(s - v[i]));
    }

    cout << g;
}
