#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    int l = 0;
    int r = 0;
    int cntArr[10] = {};
    int type = 0;
    int mx = 0;

    while (true) {
        if (type > 2) {
            cntArr[v[l]]--;
            if (cntArr[v[l]] == 0) type--;
            l++;
        } else {
            if (cntArr[v[r]] == 0) type++;
            cntArr[v[r]]++;
            r++;
        }

        if (type <= 2) mx = max(mx, r - l);

        if (r == n && type <= 2) break;
    }

    cout << mx;
}
