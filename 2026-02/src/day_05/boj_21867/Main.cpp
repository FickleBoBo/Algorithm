#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    string s;
    cin >> n >> s;

    string res;
    for (char c : s) {
        if (c == 'J' || c == 'A' || c == 'V') continue;
        res.push_back(c);
    }

    if (res.empty()) {
        cout << "nojava";
    } else {
        cout << res;
    }
}
