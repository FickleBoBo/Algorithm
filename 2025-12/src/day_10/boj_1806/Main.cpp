#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, s;
    cin >> n >> s;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    int l = 0;
    int r = 0;
    int sum = 0;
    int mn = INT_MAX;
    while (true) {
        if (sum < s) {
            sum += v[r++];
        } else {
            mn = min(mn, r - l);
            sum -= v[l++];
        }

        if (r == n && sum < s) break;
    }

    if (mn == INT_MAX) {
        cout << 0;
    } else {
        cout << mn;
    }
}
