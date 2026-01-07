#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    vector<int> v(n);
    for (int& x : v) cin >> x;
    sort(v.begin(), v.end());

    int ans = 0;
    for (int i = 0; i < n - 2; i++) {
        for (int j = i + 1; j < n - 1; j++) {
            for (int k = j + 1; k < n; k++) {
                int sum = v[i] + v[j] + v[k];
                if (sum <= m) {
                    ans = max(ans, sum);
                } else {
                    break;
                }
            }
        }
    }

    cout << ans;
}
