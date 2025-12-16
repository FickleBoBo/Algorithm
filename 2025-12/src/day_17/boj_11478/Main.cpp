#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string s;
    cin >> s;

    unordered_set<string> st;
    for (int i = 0; i < s.size(); i++) {
        for (int j = 1; j <= (int)s.size() - i; j++) {
            st.insert(s.substr(i, j));
        }
    }

    cout << st.size();
}
