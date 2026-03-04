#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string s;
    cin >> s;

    for (char c : s) {
        if (c <= 'C') {
            cout << (char)(c - 3 + 26);
        } else {
            cout << (char)(c - 3);
        }
    }
}
