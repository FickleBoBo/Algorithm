#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string s;
    cin >> s;

    for (char c : s) {
        cout << (char)(c - 'a' + 'A');
    }
}
