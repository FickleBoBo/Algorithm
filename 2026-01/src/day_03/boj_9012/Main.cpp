#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;

    for (int tc = 1; tc <= t; tc++) {
        stack<int> st;
        bool flag = true;

        string s;
        cin >> s;

        for (char c : s) {
            if (c == '(') {
                st.push(c);
            } else {
                if (st.empty()) {
                    flag = false;
                    break;
                } else {
                    st.pop();
                }
            }
        }

        if (!st.empty()) {
            flag = false;
        }

        if (flag) {
            cout << "YES\n";
        } else {
            cout << "NO\n";
        }
    }
}
