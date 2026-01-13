#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<pair<int, int>> v(n);
    for (auto& p : v) cin >> p.second >> p.first;
    sort(v.begin(), v.end());

    int end = 0;
    int cnt = 0;
    for (int i = 0; i < n; i++) {
        if (v[i].second < end) continue;

        end = v[i].first;
        cnt++;
    }

    cout << cnt;
}
