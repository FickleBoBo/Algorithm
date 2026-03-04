#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;

    while (t--) {
        int n;
        cin >> n;

        vector<int> v(n);
        for (int& x : v) cin >> x;

        stack<int> st;
        bool flag = false;

        for (int x : v) {
            if (x == 1 || (!st.empty() && st.top() + 1 == x)) {
                st.push(x);
            } else {
                while (!st.empty() && st.top() + 1 != x) {
                    while (!st.empty() && st.top() != 1) {
                        st.pop();
                    }
                    st.pop();
                }

                if (st.empty() || st.top() + 1 != x) {
                    cout << "NO\n";
                    flag = true;
                } else {
                    st.push(x);
                }
            }

            if (flag) break;
        }

        if (flag) continue;

        cout << "YES\n";
    }
}
