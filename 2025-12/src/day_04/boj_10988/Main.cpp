#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string s;
    cin >> s;

    string rs = string(s.rbegin(), s.rend());

    cout << (s == rs);
}
