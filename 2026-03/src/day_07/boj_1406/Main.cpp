#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    deque<char> f, b;

    string s;
    cin >> s;

    for (char c : s) {
        f.push_back(c);
    }

    int m;
    cin >> m;

    while (m--) {
        char c;
        cin >> c;

        if (c == 'L') {
            if (!f.empty()) {
                b.push_front(f.back());
                f.pop_back();
            }
        } else if (c == 'D') {
            if (!b.empty()) {
                f.push_back(b.front());
                b.pop_front();
            }
        } else if (c == 'B') {
            if (!f.empty()) f.pop_back();
        } else {
            cin >> c;
            f.push_back(c);
        }
    }

    while (!f.empty()) {
        cout << f.front();
        f.pop_front();
    }
    while (!b.empty()) {
        cout << b.front();
        b.pop_front();
    }
}
