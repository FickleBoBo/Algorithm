#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> a(n);
    for (auto& num : a) cin >> num;

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
    for (int num : v) {
        auto it = lower_bound(dp.begin(), dp.end(), num);

        if (it == dp.end()) {
            dp.push_back(num);
        } else {
            *it = num;
        }
    }

    cout << dp.size();
}
