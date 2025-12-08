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
    for (auto& num : v) cin >> num;

    vector<int> dp;
    vector<int> pos(n);
    vector<int> prev(n, -1);

    for (int i = 0; i < n; i++) {
        int num = v[i];
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

    cout << dp.size() << '\n';

    vector<int> lis = traceback(v, prev, pos[dp.size() - 1]);
    for (auto num : lis) {
        cout << num << ' ';
    }
}
