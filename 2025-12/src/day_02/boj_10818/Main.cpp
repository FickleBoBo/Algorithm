#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> v(n);
    for (auto& num : v) cin >> num;

    auto [mn_it, mx_it] = minmax_element(v.begin(), v.end());
    cout << *mn_it << ' ' << *mx_it;
}
