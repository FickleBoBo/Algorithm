#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<int> v(n);
    for (auto& num : v) cin >> num;
    sort(v.begin(), v.end());

    int m;
    cin >> m;

    for (int i = 0; i < m; i++) {
        int num;
        cin >> num;
        cout << upper_bound(v.begin(), v.end(), num) - lower_bound(v.begin(), v.end(), num) << ' ';
    }
}
