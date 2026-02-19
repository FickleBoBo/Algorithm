#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;

    while (t--) {
        string a, b;
        cin >> a >> b;

        string s1 = to_string(stoll(a) * stoll(b));

        int len = max(a.size(), b.size());
        vector<int> a2;
        vector<int> b2;

        for (int i = 0; i < ((int)a.size() - (int)b.size()); i++) {
            b2.push_back(1);
        }
        for (int i = 0; i < ((int)b.size() - (int)a.size()); i++) {
            a2.push_back(1);
        }

        for (char c : a) {
            a2.push_back(c - '0');
        }
        for (char c : b) {
            b2.push_back(c - '0');
        }

        string s2;
        for (int i = 0; i < len; i++) {
            s2 += to_string(a2[i] * b2[i]);
        }

        cout << (s1 == s2) << '\n';
    }
}
