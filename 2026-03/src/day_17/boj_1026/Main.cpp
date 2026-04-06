#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    vector<int> a(n);
    for (int& x : a) cin >> x;
    sort(a.begin(), a.end());

    vector<int> b(n);
    for (int& x : b) cin >> x;
    sort(b.rbegin(), b.rend());

    int s = 0;
    for (int i = 0; i < n; i++) {
        s += a[i] * b[i];
    }

    cout << s;
}
