#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string s;
    cin >> s;

    int sum = 0;
    bool has0 = false;

    for (char c : s) {
        sum += c - '0';
        if (c == '0') has0 = true;
    }

    if (sum % 3 == 0 && has0) {
        sort(s.rbegin(), s.rend());
        cout << s;
    } else {
        cout << -1;
    }
}
