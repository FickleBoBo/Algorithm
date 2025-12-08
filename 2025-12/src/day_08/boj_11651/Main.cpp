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

    for (auto p : v) {
        cout << p.second << ' ' << p.first << '\n';
    }
}
