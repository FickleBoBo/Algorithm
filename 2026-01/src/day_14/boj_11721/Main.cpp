#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string s;
    cin >> s;

    for (int i = 0; i < s.size(); i++) {
        if (i != 0 && i % 10 == 0) {
            cout << '\n';
        }

        cout << s[i];
    }
}
