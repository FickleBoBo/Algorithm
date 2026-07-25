#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    string s;
    cin >> n >> s;

    string ans;
    for (char c : s) {
        if (ans.empty()) {
            ans += c;
        } else {
            if (ans.back() == c) {
                ans.pop_back();
            } else if (ans.size() >= 2 && ans[(int)ans.size() - 2] == c) {
                ans.pop_back();
                ans.pop_back();
            } else {
                ans += c;
            }
        }
    }

    if (ans.empty()) {
        cout << -1;
    } else {
        cout << ans;
    }
}
