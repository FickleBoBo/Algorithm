#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;

    for (int tc = 1; tc <= t; tc++) {
        int n, m;
        cin >> n >> m;

        vector<int> a(n);
        for (int& x : a) cin >> x;

        vector<int> b(m);
        for (int& x : b) cin >> x;
        sort(b.begin(), b.end());

        int cnt = 0;
        for (int x : a) {
            cnt += lower_bound(b.begin(), b.end(), x) - b.begin();
        }

        cout << cnt << '\n';
    }
}
