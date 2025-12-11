#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    vector<int> dp1(n, 1);  // 앞에서 뒤로 LIS
    vector<int> dp2(n, 1);  // 뒤에서 앞으로 LIS

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (v[i] > v[j]) dp1[i] = max(dp1[i], dp1[j] + 1);
        }
    }

    for (int i = n - 1; i >= 0; i--) {
        for (int j = n - 1; j > i; j--) {
            if (v[i] > v[j]) dp2[i] = max(dp2[i], dp2[j] + 1);
        }
    }

    int mx = 0;
    for (int i = 0; i < n; i++) {
        mx = max(mx, dp1[i] + dp2[i] - 1);
    }

    cout << mx;
}
