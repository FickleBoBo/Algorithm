#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;

    while (t--) {
        string s;
        cin >> s;

        int sum = 0;
        char prev = '\0';
        int idx = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == 'O') {
                if (prev == 'X') {
                    idx = i;
                }
            } else {
                if (prev == 'O') {
                    int len = i - idx;
                    sum += len * (len + 1) / 2;
                }
            }

            prev = s[i];
        }

        if (s.back() == 'O') {
            int len = (int)s.size() - idx;
            sum += len * (len + 1) / 2;
        }

        cout << sum << '\n';
    }
}
