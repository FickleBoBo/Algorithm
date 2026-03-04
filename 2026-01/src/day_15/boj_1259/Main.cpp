#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    while (true) {
        string s;
        cin >> s;

        if (s == "0") break;

        if (s == string(s.rbegin(), s.rend())) {
            cout << "yes\n";
        } else {
            cout << "no\n";
        }
    }
}
