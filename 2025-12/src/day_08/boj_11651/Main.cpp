#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<pair<int, int>> v(n);
    for (auto& [y, x] : v) cin >> x >> y;
    sort(v.begin(), v.end());

    for (auto& [y, x] : v) {
        cout << x << ' ' << y << '\n';
    }
}
