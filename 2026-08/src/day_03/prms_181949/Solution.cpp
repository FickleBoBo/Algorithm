#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string s, ans;
    cin >> s;

    for (char c : s) {
        if ('a' <= c && c <= 'z') {
            ans += (char)(c - 'a' + 'A');
        } else {
            ans += (char)(c - 'A' + 'a');
        }
    }

    cout << ans;
}
