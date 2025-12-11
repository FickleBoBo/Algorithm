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

    int l = 0;
    int r = n - 1;
    int sum = INT_MAX;
    pair<int, int> ans{};

    while (l < r) {
        if (v[l] + v[r] > 0) {
            if (abs(v[l] + v[r]) < sum) {
                sum = abs(v[l] + v[r]);
                ans = {v[l], v[r]};
            }
            r--;
        } else if (v[l] + v[r] < 0) {
            if (abs(v[l] + v[r]) < sum) {
                sum = abs(v[l] + v[r]);
                ans = {v[l], v[r]};
            }
            l++;
        } else {
            ans = {v[l], v[r]};
            break;
        }
    }

    cout << ans.first << ' ' << ans.second;
}
