#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    stack<char> st;
    int sum = 0;
    int x = 1;

    string s;
    cin >> s;
    char prv = '\0';

    for (char c : s) {
        if (c == '(') {
            x *= 2;
            st.push(c);
        } else if (c == '[') {
            x *= 3;
            st.push(c);
        } else if (c == ')') {
            if (st.empty() || st.top() != '(') {
                cout << 0;
                return 0;
            }

            if (prv == '(') sum += x;
            x /= 2;
            st.pop();
        } else {
            if (st.empty() || st.top() != '[') {
                cout << 0;
                return 0;
            }

            if (prv == '[') sum += x;
            x /= 3;
            st.pop();
        }

        prv = c;
    }

    if (st.empty()) {
        cout << sum;
    } else {
        cout << 0;
    }
}
