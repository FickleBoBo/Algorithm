#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;

    while (t--) {
        vector<int> v(10);
        for (int& x : v) cin >> x;
        sort(v.begin(), v.end());

        cout << v[7] << '\n';
    }
}
