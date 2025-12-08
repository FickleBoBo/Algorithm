#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> v(n);
    for (auto& num : v) cin >> num;

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
