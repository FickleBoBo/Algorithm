#include <bits/stdc++.h>
using namespace std;

int cnt[26];

string get_dna(int n, int mn) {
    if (cnt[0] == mn) return string(n, 'A');
    if (cnt[2] == mn) return string(n, 'C');
    if (cnt[6] == mn) return string(n, 'G');
    return string(n, 'T');
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    string s;
    cin >> n >> s;

    for (char c : s) {
        cnt[c - 'A']++;
    }

    int mn = min({cnt[0], cnt[2], cnt[6], cnt[19]});

    cout << mn << '\n';
    cout << get_dna(n, mn);
}
