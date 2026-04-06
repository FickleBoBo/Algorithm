#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    vector<pair<int, int>> v(n);
    for (auto& [x, y] : v) cin >> x >> y;
    sort(v.begin(), v.end());

    int ans = 0;
    auto [start, end] = v[0];
    for (auto [x, y] : v) {
        if (end >= x) {
            end = max(end, y);
        } else {
            ans += end - start;
            start = x;
            end = y;
        }
    }
    ans += end - start;

    cout << ans;
}
