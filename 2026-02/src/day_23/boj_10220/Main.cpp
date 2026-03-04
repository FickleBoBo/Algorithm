#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;

    while (t--) {
        int n;
        cin >> n;

        if (n == 4) {
            cout << 2 << '\n';
        } else if (n <= 3 || n == 6) {
            cout << 0 << '\n';
        } else {
            cout << 1 << '\n';
        }
    }
}
