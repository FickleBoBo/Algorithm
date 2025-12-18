#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    unordered_map<string, string> mp;

    int n, m;
    cin >> n >> m;

    for (int i = 1; i <= n; i++) {
        string name;
        cin >> name;

        mp[to_string(i)] = name;
        mp[name] = to_string(i);
    }

    for (int i = 0; i < m; i++) {
        string s;
        cin >> s;
        cout << mp[s] << '\n';
    }
}
