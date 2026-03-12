#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;
    int cnt = 0;

    while (n--) {
        stack<char> st;

        string s;
        cin >> s;

        for (char c : s) {
            if (st.empty()) {
                st.push(c);
            } else {
                if (st.top() == c) {
                    st.pop();
                } else {
                    st.push(c);
                }
            }
        }

        if (st.empty()) cnt++;
    }

    cout << cnt;
}
