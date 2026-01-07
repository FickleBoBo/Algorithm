#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    unordered_set<string> st;
    st.insert("ChongChong");

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        string s1, s2;
        cin >> s1 >> s2;

        if (st.count(s1)) st.insert(s2);
        if (st.count(s2)) st.insert(s1);
    }

    cout << st.size();
}
