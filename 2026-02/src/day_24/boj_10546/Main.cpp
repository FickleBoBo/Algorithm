#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    unordered_map<string, int> mp;

    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        string s;
        cin >> s;
        mp[s]++;
    }
    for (int i = 0; i < n - 1; i++) {
        string s;
        cin >> s;
        mp[s]--;
    }

    for (auto& [k, v] : mp) {
        if (v == 1) {
            cout << k;
            return 0;
        }
    }
}
