#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string s, t;
    cin >> s >> t;
    int slen = s.size();
    int tlen = t.size();

    while (tlen > slen) {
        if (t[tlen - 1] == 'A') {
            tlen--;
        } else {
            tlen--;
            reverse(t.begin(), t.begin() + tlen);
        }
    }

    for (int i = 0; i < tlen; i++) {
        if (s[i] != t[i]) {
            cout << 0;
            return 0;
        }
    }

    cout << 1;
}
