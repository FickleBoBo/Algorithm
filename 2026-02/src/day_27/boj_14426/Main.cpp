#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;
    unordered_set<string> st;

    while (n--) {
        string s;
        cin >> s;
        for (int i = 0; i < s.size(); i++) {
            st.insert(s.substr(0, i + 1));
        }
    }

    int cnt = 0;
    while (m--) {
        string s;
        cin >> s;
        if (st.count(s)) cnt++;
    }

    cout << cnt;
}
