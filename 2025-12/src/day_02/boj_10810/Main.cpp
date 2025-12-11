#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    vector<int> v(n);
    for (int i = 0; i < m; i++) {
        int s, e, x;
        cin >> s >> e >> x;

        fill(v.begin() + s - 1, v.begin() + e, x);
    }

    for (int x : v) {
        cout << x << ' ';
    }
}
