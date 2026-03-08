#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    stack<int> st;
    string ans;
    int cur = 1;

    int n;
    cin >> n;

    while (n--) {
        int x;
        cin >> x;

        while (cur <= x) {
            st.push(cur++);
            ans += "+\n";
        }

        if (st.top() != x) {
            cout << "NO";
            return 0;
        }

        st.pop();
        ans += "-\n";
    }

    cout << ans;
}
