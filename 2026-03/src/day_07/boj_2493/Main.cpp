#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    stack<pair<int, int>> st;
    for (int i = 1; i <= n; i++) {
        int x;
        cin >> x;

        while (!st.empty() && st.top().first < x) {
            st.pop();
        }

        cout << (st.empty() ? 0 : st.top().second) << ' ';
        st.push({x, i});
    }
}
