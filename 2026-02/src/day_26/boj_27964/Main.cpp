#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    unordered_set<string> st;

    int n;
    cin >> n;

    while (n--) {
        string s;
        cin >> s;
        if (string(s.end() - 6, s.end()) == "Cheese") {
            st.insert(s);
        }
    }

    if (st.size() >= 4) {
        cout << "yummy";
    } else {
        cout << "sad";
    }
}
