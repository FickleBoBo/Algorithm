#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;

    while (t--) {
        int s, k;
        cin >> s >> k;

        if (k % 2) {
            cout << s % 2 << '\n';
        } else {
            if (s % (k + 1) == k) {
                cout << k << '\n';
            } else {
                cout << s % (k + 1) % 2 << '\n';
            }
        }
    }
}
