#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    unordered_map<int, int> mp;
    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;

        mp[num]++;
    }

    int m;
    cin >> m;

    for (int i = 0; i < m; i++) {
        int num;
        cin >> num;

        if (mp.find(num) != mp.end()) {
            cout << mp[num] << ' ';
        } else {
            cout << "0 ";
        }
    }
}
