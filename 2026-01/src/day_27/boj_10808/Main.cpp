#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string s;
    cin >> s;

    vector<int> cnt(26);

    for (char c : s) {
        cnt[c - 'a']++;
    }

    for (int x : cnt) {
        cout << x << ' ';
    }
}
