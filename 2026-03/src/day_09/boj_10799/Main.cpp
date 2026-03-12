#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    stack<char> st;
    int cnt = 0;

    string s;
    cin >> s;
    char prv = '\0';

    for (char c : s) {
        if (c == '(') {
            st.push(c);
        } else {
            if (prv == '(') {
                st.pop();
                cnt += st.size();
            } else {
                st.pop();
                cnt++;
            }
        }

        prv = c;
    }

    cout << cnt;
}
