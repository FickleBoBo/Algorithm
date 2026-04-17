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

    vector<int> dp;
    vector<int> pos(n);
    vector<int> prv(n, -1);

    for (int i = 0; i < n; i++) {
        int x = v[i];
        auto it = lower_bound(dp.begin(), dp.end(), x);
        int idx = it - dp.begin();

        if (it == dp.end()) {
            dp.push_back(x);
        } else {
            *it = x;
        }

        pos[idx] = i;
        if (idx > 0) prv[i] = pos[idx - 1];
    }

    traceback(v, prv, pos[dp.size() - 1]);

    cout << dp.size() << '\n';
    for (int x : lis) {
        cout << x << ' ';
    }
}
