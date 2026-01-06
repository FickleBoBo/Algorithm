#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;

    for (int tc = 1; tc <= t; tc++) {
        int a, b;
        cin >> a >> b;
        cout << "Case " << tc << ": " << a + b << '\n';
    }
}
