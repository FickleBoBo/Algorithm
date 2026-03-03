#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string s, t;
    cin >> s >> t;
    int slen = s.size();
    int len = t.size();

    while (len > slen) {
        if (t[len - 1] == 'A') {
            len--;
        } else {
            len--;
            reverse(t.begin(), t.begin() + len);
        }
    }

    for (int i = 0; i < len; i++) {
        if (s[i] != t[i]) {
            cout << 0;
            return 0;
        }
    }

    cout << 1;
}
