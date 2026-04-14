#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m, k;
    cin >> n >> m >> k;

    if ((n + k - 1) / k > m || n - k + 1 < m) {
        cout << -1;
        return 0;
    }

    vector<int> v(n);
    iota(v.begin(), v.end(), 1);

    for (int i = 0; i < n; i += k) {
        reverse(v.begin() + i, v.begin() + min(i + k, n));
    }

    int cnt = m - (n + k - 1) / k;
    int right = n - 1;
    while (cnt > 0) {
        int max = 0;
        int idx = 0;
        for (int i = 0; i <= right; i++) {
            if (v[i] > max) {
                max = v[i];
                idx = i;
            }
        }

        for (int i = idx; i < right; i++) {
            v[i] = v[i + 1];
        }
        v[right] = max;

        if (idx != right) cnt--;
        right--;
    }

    for (int x : v) {
        cout << x << ' ';
    }
}
