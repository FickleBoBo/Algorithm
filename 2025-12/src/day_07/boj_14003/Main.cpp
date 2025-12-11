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

    vector<int> dp;
    vector<int> pos(n);
    vector<int> prev(n, -1);

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
        if (idx > 0) prev[i] = pos[idx - 1];
    }

    cout << dp.size() << '\n';

    vector<int> lis = traceback(v, prev, pos[dp.size() - 1]);
    for (int x : lis) {
        cout << x << ' ';
    }
}
