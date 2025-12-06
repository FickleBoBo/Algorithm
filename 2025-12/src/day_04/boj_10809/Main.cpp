#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string s;
    cin >> s;

    for (int i = 0; i < 26; i++) {
        size_t pos = s.find((char)(i + 'a'));

        if (pos == string::npos) {
            cout << -1 << ' ';
        } else {
            cout << pos << ' ';
        }
    }
}
