#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    stack<int> st;

    int k;
    cin >> k;

    while (k--) {
        int x;
        cin >> x;

        if (x == 0) {
            st.pop();
        } else {
            st.push(x);
        }
    }

    int sum = 0;
    while (!st.empty()) {
        sum += st.top();
        st.pop();
    }

    cout << sum;
}
