#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, k;
    cin >> n >> k;

    vector<int> v(n);
    for (int& x : v) cin >> x;
    sort(v.begin(), v.end());

    cout << v[n - k];
}
