#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;

    while (t--) {
        int n;
        cin >> n;

        vector<pair<int, string>> v(n);
        for (auto& [amount, name] : v) cin >> name >> amount;
        sort(v.rbegin(), v.rend());

        cout << v.front().second << '\n';
    }
}
