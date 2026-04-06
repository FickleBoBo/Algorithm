#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;

    while (t--) {
        string s;
        cin >> s;

        int sum = 0;
        char prv = '\0';
        int idx = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == 'O') {
                if (prv == 'X') {
                    idx = i;
                }
            } else {
                if (prv == 'O') {
                    int len = i - idx;
                    sum += len * (len + 1) / 2;
                }
            }

            prv = s[i];
        }

        if (s.back() == 'O') {
            int len = (int)s.size() - idx;
            sum += len * (len + 1) / 2;
        }

        cout << sum << '\n';
    }
}
