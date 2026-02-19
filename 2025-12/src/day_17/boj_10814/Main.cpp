#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<pair<int, string>> v(n);
    for (auto& [age, name] : v) cin >> age >> name;
    stable_sort(v.begin(), v.end(), [](const auto& a, const auto& b) {
        return a.first < b.first;
    });

    for (auto& [age, name] : v) {
        cout << age << ' ' << name << '\n';
    }
}
