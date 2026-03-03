#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int a, b, c;
    cin >> a >> b >> c;

    int mx = max({a, b, c});
    int left = a + b + c - mx;

    if (mx < left) {
        cout << a + b + c;
    } else {
        cout << 2 * left - 1;
    }
}
