#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    vector<int> v(3);
    for (int& x : v) cin >> x;
    sort(v.begin(), v.end());

    cout << v[1];
}
