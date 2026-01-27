#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    string s = to_string(n);
    string res;

    for (int i = 0; i < n; i++) {
        res += s;
    }

    for (int i = 0; i < min((int)res.size(), m); i++) {
        cout << res[i];
    }
}
