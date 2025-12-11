#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    unordered_map<int, int> mp;
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;

        mp[x]++;
    }

    int m;
    cin >> m;

    for (int i = 0; i < m; i++) {
        int x;
        cin >> x;

        auto it = mp.find(x);
        if (it != mp.end()) {
            cout << it->second << ' ';
        } else {
            cout << "0 ";
        }
    }
}
