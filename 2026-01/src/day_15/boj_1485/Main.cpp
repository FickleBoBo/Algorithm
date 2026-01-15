#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;

    for (int tc = 1; tc <= t; tc++) {
        vector<pair<long long, long long>> v(4);
        for (auto& p : v) cin >> p.first >> p.second;
        sort(v.begin(), v.end());

        long long side1 = (v[0].first - v[1].first) * (v[0].first - v[1].first) +
                          (v[0].second - v[1].second) * (v[0].second - v[1].second);
        long long side2 = (v[0].first - v[2].first) * (v[0].first - v[2].first) +
                          (v[0].second - v[2].second) * (v[0].second - v[2].second);
        long long side3 = (v[3].first - v[1].first) * (v[3].first - v[1].first) +
                          (v[3].second - v[1].second) * (v[3].second - v[1].second);
        long long side4 = (v[3].first - v[2].first) * (v[3].first - v[2].first) +
                          (v[3].second - v[2].second) * (v[3].second - v[2].second);
        long long diagonal1 = (v[3].first - v[0].first) * (v[3].first - v[0].first) +
                              (v[3].second - v[0].second) * (v[3].second - v[0].second);
        long long diagonal2 = (v[2].first - v[1].first) * (v[2].first - v[1].first) +
                              (v[2].second - v[1].second) * (v[2].second - v[1].second);

        cout << (side1 == side2 && side1 == side3 && side1 == side4 && diagonal1 == diagonal2) << '\n';
    }
}
