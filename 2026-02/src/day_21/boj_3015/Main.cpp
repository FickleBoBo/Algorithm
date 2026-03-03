#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    stack<pair<int, int>> st;
    long long ans = 0;

    int n;
    cin >> n;

    while (n--) {
        int x;
        cin >> x;
        int cnt = 1;

        while (!st.empty() && st.top().first < x) {
            ans += st.top().second;
            st.pop();
        }

        if (!st.empty() && st.top().first == x) {
            ans += st.top().second;
            cnt += st.top().second;
            st.pop();
        }

        if (!st.empty()) ans++;

        st.push({x, cnt});
    }

    cout << ans;
}
