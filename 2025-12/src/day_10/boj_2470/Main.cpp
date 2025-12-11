#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> v(n);
    for (int& x : v) cin >> x;
    sort(v.begin(), v.end());

    int sum = INT_MAX;
    pair<int, int> ans{};

    for (int i = 0; i < n - 1; i++) {
        int idx1 = lower_bound(v.begin() + i + 1, v.end(), -v[i]) - v.begin();
        int idx2 = upper_bound(v.begin() + i + 1, v.end(), -v[i]) - v.begin() - 1;

        if (idx1 != n && abs(v[i] + v[idx1]) < sum) {
            sum = abs(v[i] + v[idx1]);
            ans = {v[i], v[idx1]};
        }

        if (idx2 != i && idx2 != n && abs(v[i] + v[idx2]) < sum) {
            sum = abs(v[i] + v[idx2]);
            ans = {v[i], v[idx2]};
        }
    }

    cout << ans.first << ' ' << ans.second;
}
