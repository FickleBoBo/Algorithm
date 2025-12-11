#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> v(n);
    for (int& x : v) cin >> x;

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
