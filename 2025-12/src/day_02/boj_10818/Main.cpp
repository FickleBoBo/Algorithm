#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    auto [mn_it, mx_it] = minmax_element(v.begin(), v.end());
    cout << *mn_it << ' ' << *mx_it;
}
