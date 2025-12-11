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
        long long num = v[i];

        int l = i + 1;
        int r = n - 1;

        while (l < r) {
            if (num + v[l] + v[r] > 0) {
                if (llabs(num + v[l] + v[r]) < sum) {
                    sum = llabs(num + v[l] + v[r]);
                    ans = {v[i], v[l], v[r]};
                }
                r--;
            } else if (num + v[l] + v[r] < 0) {
                if (llabs(num + v[l] + v[r]) < sum) {
                    sum = llabs(num + v[l] + v[r]);
                    ans = {v[i], v[l], v[r]};
                }
                l++;
            } else {
                ans = {v[i], v[l], v[r]};

                cout << ans[0] << ' ' << ans[1] << ' ' << ans[2];
                return 0;
            }
        }
    }

    cout << ans[0] << ' ' << ans[1] << ' ' << ans[2];
}
