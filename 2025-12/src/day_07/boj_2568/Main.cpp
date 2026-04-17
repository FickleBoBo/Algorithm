#include <bits/stdc++.h>
using namespace std;

set<int> st;

void traceback(vector<pair<int, int>>& v, vector<int>& prv, int pos) {
    for (auto p : v) st.insert(p.second);

    while (pos != -1) {
        st.erase(v[pos].second);
        pos = prv[pos];
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    vector<pair<int, int>> v(n);
    for (auto& [a, b] : v) cin >> b >> a;
    sort(v.begin(), v.end());

    vector<int> dp;
    vector<int> pos(n);
    vector<int> prv(n, -1);

    for (int i = 0; i < n; i++) {
        int x = v[i].second;
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

    cout << n - dp.size() << '\n';
    for (int x : st) {
        cout << x << '\n';
    }
}
