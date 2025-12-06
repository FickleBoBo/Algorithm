#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    vector<int> v(1 + n);
    iota(v.begin(), v.end(), 0);

    for (int i = 0; i < m; i++) {
        int s, e;
        cin >> s >> e;

        swap(v[s], v[e]);
    }

    for (int i = 1; i <= n; i++) {
        cout << v[i] << ' ';
    }
}
