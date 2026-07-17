#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string s;
    cin >> s;

    int ans = 0;
    int sign = 1;
    int tmp = 0;

    for (char c : s) {
        if (c == '+' || c == '-') {
            ans += tmp * sign;
            tmp = 0;

            if (c == '-') {
                sign = -1;
            }
        } else {
            tmp *= 10;
            tmp += c - '0';
        }
    }
    ans += tmp * sign;

    cout << ans;
}
