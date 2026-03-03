#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string s;
    cin >> s;

    vector<int> cnt(26);
    for (char c : s) {
        cnt[c - 'A']++;
    }

    bool flag = true;
    if (s.size() % 2) {
        int oddCnt = 0;
        for (int x : cnt) {
            if (x % 2 == 1) oddCnt++;
        }

        if (oddCnt != 1) flag = false;
    } else {
        for (int x : cnt) {
            if (x % 2 == 1) {
                flag = false;
                break;
            }
        }
    }

    if (flag) {
        for (int i = 0; i < 26; i++) {
            if (cnt[i]) {
                cout << string(cnt[i] / 2, (i + 'A'));
            }
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2) {
                cout << (char)(i + 'A');
                break;
            }
        }
        for (int i = 25; i >= 0; i--) {
            if (cnt[i]) {
                cout << string(cnt[i] / 2, (i + 'A'));
            }
        }
    } else {
        cout << "I'm Sorry Hansoo";
    }
}
