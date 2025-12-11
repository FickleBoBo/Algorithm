#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<long long> v(n);
    for (long long& x : v) cin >> x;
    sort(v.begin(), v.end());

    long long sum = 3000000000LL;
    vector<long long> ans(3);

    for (int i = 0; i < n - 2; i++) {
        for (int j = i + 1; j < n - 1; j++) {
            int idx1 = lower_bound(v.begin() + j + 1, v.end(), -(v[i] + v[j])) - v.begin();
            int idx2 = upper_bound(v.begin() + j + 1, v.end(), -(v[i] + v[j])) - v.begin() - 1;

            if (idx1 != n && llabs(v[i] + v[j] + v[idx1]) < sum) {
                sum = llabs(v[i] + v[j] + v[idx1]);
                ans = {v[i], v[j], v[idx1]};
            }

            if (idx2 != j && idx2 != n && llabs(v[i] + v[j] + v[idx2]) < sum) {
                sum = llabs(v[i] + v[j] + v[idx2]);
                ans = {v[i], v[j], v[idx2]};
            }
        }
    }

    cout << ans[0] << ' ' << ans[1] << ' ' << ans[2];
}
