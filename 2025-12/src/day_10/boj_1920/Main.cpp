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

    int m;
    cin >> m;

    for (int i = 0; i < m; i++) {
        int x;
        cin >> x;

        if (binary_search(v.begin(), v.end(), x)) {
            cout << 1 << '\n';
        } else {
            cout << 0 << '\n';
        }
    }
}
