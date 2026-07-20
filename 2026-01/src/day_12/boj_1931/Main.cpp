#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    vector<pair<int, int>> v(n);
    for (auto& [e, s] : v) cin >> s >> e;
    sort(v.begin(), v.end());

    int last = 0;
    int cnt = 0;
    for (auto [e, s] : v) {
        if (s < last) continue;

        last = e;
        cnt++;
    }

    cout << cnt;
}
