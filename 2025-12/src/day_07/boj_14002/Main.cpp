#include <bits/stdc++.h>
using namespace std;

vector<int> traceback(const vector<int>& v, const vector<int>& prev, int pos) {
    vector<int> lis;

    while (pos != -1) {
        lis.push_back(v[pos]);
        pos = prev[pos];
    }

    reverse(lis.begin(), lis.end());
    return lis;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    vector<int> dp(n, 1);
    vector<int> prev(n, -1);

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (v[i] > v[j] && dp[j] + 1 > dp[i]) {
                dp[i] = dp[j] + 1;
                prev[i] = j;
            }
        }
    }

    int mx = 0;
    int pos = 0;
    for (int i = 0; i < n; i++) {
        if (dp[i] > mx) {
            mx = dp[i];
            pos = i;
        }
    }

    cout << mx << '\n';

    vector<int> lis = traceback(v, prev, pos);
    for (int x : lis) {
        cout << x << ' ';
    }
}
