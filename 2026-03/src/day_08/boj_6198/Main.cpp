#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    stack<int> st;
    long long cnt = 0;

    int n;
    cin >> n;

    while (n--) {
        int h;
        cin >> h;

        while (!st.empty() && st.top() <= h) {
            st.pop();
        }

        cnt += st.size();
        st.push(h);
    }

    cout << cnt;
}
