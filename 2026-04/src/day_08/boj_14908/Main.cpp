#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    vector<tuple<int, int, int>> v(n);
    for (int i = 0; i < n; i++) {
        int t, s;
        cin >> t >> s;
        v[i] = {i + 1, t, s};
    }
    stable_sort(v.begin(), v.end(), [](auto& a, auto& b) {
        return get<1>(a) * get<2>(b) < get<1>(b) * get<2>(a);
    });

    for (auto [x, t, s] : v) {
        cout << x << ' ';
    }
}
