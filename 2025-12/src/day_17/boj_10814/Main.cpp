#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<pair<int, string>> v(n);
    for (auto& p : v) cin >> p.first >> p.second;
    stable_sort(v.begin(), v.end(), [](const auto& a, const auto& b) {
        return a.first < b.first;
    });

    for (auto& p : v) {
        cout << p.first << ' ' << p.second << '\n';
    }
}
