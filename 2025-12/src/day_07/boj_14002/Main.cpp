#include <bits/stdc++.h>
using namespace std;

vector<int> lis;

void traceback(vector<int>& v, vector<int>& prv, int pos) {
    while (pos != -1) {
        lis.push_back(v[pos]);
        pos = prv[pos];
    }

    reverse(lis.begin(), lis.end());
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    vector<int> dp(n, 1);
    vector<int> prv(n, -1);

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (v[i] > v[j] && dp[j] + 1 > dp[i]) {
                dp[i] = dp[j] + 1;
                prv[i] = j;
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

    traceback(v, prv, pos);

    cout << mx << '\n';
    for (int x : lis) {
        cout << x << ' ';
    }
}
