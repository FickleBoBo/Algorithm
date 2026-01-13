#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> v(n);
    for (int& x : v) cin >> x;
    sort(v.begin(), v.end());

    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum += v[i] * (n - i);
    }

    cout << sum;
}
