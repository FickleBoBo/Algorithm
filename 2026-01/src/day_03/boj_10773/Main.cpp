#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    stack<int> st;

    int k;
    cin >> k;

    for (int i = 0; i < k; i++) {
        int n;
        cin >> n;

        if (n == 0) {
            st.pop();
        } else {
            st.push(n);
        }
    }

    int sum = 0;
    while (!st.empty()) {
        sum += st.top();
        st.pop();
    }

    cout << sum;
}
