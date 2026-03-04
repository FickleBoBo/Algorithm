#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;

    vector<int> v(n);
    for (int& x : v) cin >> x;

    int sum = 0;
    for (int i = n - 1; i >= 0; i--) {
        sum += v[i];
        if (sum >= m) {
            cout << i + 1;
            return 0;
        }
    }

    cout << -1;
}
