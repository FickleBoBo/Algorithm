#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int l, p;
    cin >> l >> p;

    vector<int> v(5);
    for (int& x : v) cin >> x;

    for (int x : v) {
        cout << x - l * p << ' ';
    }
}
