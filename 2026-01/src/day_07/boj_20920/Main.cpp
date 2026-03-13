#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;

    unordered_map<string, int> mp;
    while (n--) {
        string s;
        cin >> s;

        if (s.size() < m) continue;
        mp[s]++;
    }

    vector<pair<string, int>> list;
    for (auto& [k, v] : mp) {
        list.push_back({k, v});
    }
    sort(list.begin(), list.end(), [](auto& a, auto& b) {
        if (a.second != b.second) return a.second > b.second;
        if (a.first.size() != b.first.size()) return a.first.size() > b.first.size();
        return a.first < b.first;
    });

    for (auto& [k, _] : list) {
        cout << k << '\n';
    }
}
