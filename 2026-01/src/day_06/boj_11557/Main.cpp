#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;

    for (int tc = 1; tc <= t; tc++) {
        int n;
        cin >> n;

        vector<pair<int, string>> v;
        for (int i = 0; i < n; i++) {
            string name;
            int amount;
            cin >> name >> amount;

            v.emplace_back(amount, name);
        }
        sort(v.begin(), v.end());

        cout << v.back().second << '\n';
    }
}
