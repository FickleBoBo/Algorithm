#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<string> v(n);
    for (string& x : v) cin >> x;
    sort(v.begin(), v.end(), [](const string& a, const string& b) {
        if (a.size() != b.size()) return a.size() < b.size();
        return a < b;
    });

    string prev = "";
    for (string& s : v) {
        if (s == prev) continue;

        cout << s << '\n';
        prev = s;
    }
}
