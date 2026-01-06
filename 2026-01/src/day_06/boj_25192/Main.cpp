#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    set<string> st;
    int cnt = 0;

    for (int i = 0; i < n; i++) {
        string s;
        cin >> s;

        if (s == "ENTER") {
            cnt += st.size();
            st.clear();
        } else {
            st.insert(s);
        }
    }
    cnt += st.size();

    cout << cnt;
}
