#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string s;
    cin >> s;

    int cnt = 0;

    for (int i = 0; i < s.size(); i++) {
        if (s[i] == 'c') {
            if (i + 1 < s.size() && (s[i + 1] == '=' || s[i + 1] == '-')) {
                i++;
            }
        } else if (s[i] == 'd') {
            if (i + 1 < s.size() && s[i + 1] == '-') {
                i++;
            } else if (i + 2 < s.size() && s[i + 1] == 'z' && s[i + 2] == '=') {
                i += 2;
            }
        } else if (s[i] == 'l' || s[i] == 'n') {
            if (i + 1 < s.size() && s[i + 1] == 'j') {
                i++;
            }
        } else if (s[i] == 's' || s[i] == 'z') {
            if (i + 1 < s.size() && s[i + 1] == '=') {
                i++;
            }
        }

        cnt++;
    }

    cout << cnt;
}
