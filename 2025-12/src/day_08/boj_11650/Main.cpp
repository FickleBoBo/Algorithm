#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<pair<int, int>> v(n);
    for (auto& [x, y] : v) cin >> x >> y;
    sort(v.begin(), v.end());

    for (auto& [x, y] : v) {
        cout << x << ' ' << y << '\n';
    }
}
