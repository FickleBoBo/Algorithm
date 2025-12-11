#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    vector<int> v(n);
    iota(v.begin(), v.end(), 1);

    for (int i = 0; i < m; i++) {
        int s, e;
        cin >> s >> e;

        swap(v[s - 1], v[e - 1]);
    }

    for (int x : v) {
        cout << x << ' ';
    }
}
