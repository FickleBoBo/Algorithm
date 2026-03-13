#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    unordered_map<string, string> mp;

    int n, m;
    cin >> n >> m;

    for (int i = 1; i <= n; i++) {
        string name;
        cin >> name;

        mp[to_string(i)] = name;
        mp[name] = to_string(i);
    }

    while (m--) {
        string s;
        cin >> s;
        cout << mp[s] << '\n';
    }
}
