#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    while (true) {
        string s;
        getline(cin, s);

        if (s == ".") break;

        stack<char> st;
        bool flag = true;

        for (char c : s) {
            if (c == '(' || c == '[') {
                st.push(c);
            } else if (c == ')' || c == ']') {
                if (st.empty()) {
                    flag = false;
                    break;
                }

                if (st.top() == '(' && c == ')' || st.top() == '[' && c == ']') {
                    st.pop();
                } else {
                    flag = false;
                    break;
                }
            }
        }

        if (!st.empty()) {
            flag = false;
        }

        if (flag) {
            cout << "yes\n";
        } else {
            cout << "no\n";
        }
    }
}
