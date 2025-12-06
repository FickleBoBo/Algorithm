#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;

    for (int tc = 1; tc <= t; tc++) {
        int r;
        string s;
        cin >> r >> s;

        for (char c : s) {
            cout << string(r, c);
        }
        cout << '\n';
    }
}
