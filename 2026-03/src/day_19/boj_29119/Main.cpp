#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    vector<string> v(n);
    for (string& s : v) cin >> s;
    sort(v.begin(), v.end(), [](auto& a, auto& b) {
        return b + a < a + b;
    });

    for (string& s : v) {
        cout << s << ' ';
    }
}
