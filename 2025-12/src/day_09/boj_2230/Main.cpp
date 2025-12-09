#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    vector<int> v(n);
    for (auto& num : v) cin >> num;
    sort(v.begin(), v.end());

    int l = 0;
    int r = 0;
    int mn = INT_MAX;
    while (l < n && r < n) {
        if (v[r] - v[l] < m) {
            r++;
        } else {
            mn = min(mn, v[r] - v[l]);
            l++;
        }
    }

    cout << mn;
}
