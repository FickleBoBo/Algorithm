#include <bits/stdc++.h>
using namespace std;

set<int> traceback(const vector<pair<int, int>>& v, const vector<int>& prev, int pos) {
    set<int> st;
    for (auto p : v) st.insert(p.second);

    while (pos != -1) {
        st.erase(v[pos].second);
        pos = prev[pos];
    }

    return st;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<pair<int, int>> v(n);
    for (auto& p : v) cin >> p.second >> p.first;
    sort(v.begin(), v.end());

    vector<int> dp;
    vector<int> pos(n);
    vector<int> prev(n, -1);

    for (int i = 0; i < n; i++) {
        int num = v[i].second;
        auto it = lower_bound(dp.begin(), dp.end(), num);
        int idx = it - dp.begin();

        if (it == dp.end()) {
            dp.push_back(num);
        } else {
            *it = num;
        }

        pos[idx] = i;
        if (idx > 0) prev[i] = pos[idx - 1];
    }

    cout << n - dp.size() << '\n';

    set<int> nonLis = traceback(v, prev, pos[dp.size() - 1]);
    for (auto num : nonLis) {
        cout << num << '\n';
    }
}
