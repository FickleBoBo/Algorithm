#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> a(n);
    for (int& x : a) cin >> x;

    vector<pair<int, int>> b(n);
    for (int i = 0; i < n; i++) {
        cin >> b[i].first;
        b[i].second = i;
    }
    sort(b.begin(), b.end());

    vector<int> v(n);
    for (int i = 0; i < n; i++) {
        v[i] = b[a[i] - 1].second;
    }

    vector<int> dp;
    for (int x : v) {
        auto it = lower_bound(dp.begin(), dp.end(), x);

        if (it == dp.end()) {
            dp.push_back(x);
        } else {
            *it = x;
        }
    }

    cout << dp.size();
}
