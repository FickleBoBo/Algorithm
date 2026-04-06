#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string s;
    cin >> s;

    int cnt0 = 0;
    int cnt1 = 0;
    char prv = '\0';

    for (char c : s) {
        if (c != prv) {
            if (c == '0') {
                cnt0++;
            } else {
                cnt1++;
            }
        }

        prv = c;
    }

    cout << min(cnt0, cnt1);
}
