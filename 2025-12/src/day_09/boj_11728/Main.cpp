#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    vector<int> v(n + m);
    for (int& x : v) cin >> x;
    sort(v.begin(), v.end());

    for (int x : v) {
        cout << x << ' ';
    }
}
