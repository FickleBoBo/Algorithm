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
        sort(a.begin(), a.end());

        vector<int> b(m);
        for (int& x : b) cin >> x;
        sort(b.begin(), b.end());

        int pa = 0;  // A의 포인터
        int pb = 0;  // B의 포인터
        int cnt = 0;

        while (pa < n) {
            if (pb < m && a[pa] > b[pb]) {
                pb++;
            } else {
                cnt += pb;
                pa++;
            }
        }

        cout << cnt << '\n';
    }
}
