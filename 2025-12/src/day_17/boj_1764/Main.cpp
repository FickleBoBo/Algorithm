#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    unordered_set<string> st1;
    for (int i = 0; i < n; i++) {
        string s;
        cin >> s;
        st1.insert(s);
    }

    unordered_set<string> st2;
    for (int i = 0; i < m; i++) {
        string s;
        cin >> s;
        st2.insert(s);
    }

    set<string> inter;
    if (st1.size() > st2.size()) swap(st1, st2);

    for (const string& s : st1) {
        if (st2.count(s)) inter.insert(s);
    }

    cout << inter.size() << '\n';
    for (const string& s : inter) {
        cout << s << '\n';
    }
}
