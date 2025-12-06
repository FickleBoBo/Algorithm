#include <bits/stdc++.h>
using namespace std;

string get_dna(int n, const int cntArr[], int mn) {
    if (cntArr[0] == mn) return string(n, 'A');
    if (cntArr[2] == mn) return string(n, 'C');
    if (cntArr[6] == mn) return string(n, 'G');
    return string(n, 'T');
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    string s;
    cin >> n >> s;

    int cntArr[26] = {};
    for (char c : s) {
        cntArr[c - 'A']++;
    }

    int mn = min({cntArr[0], cntArr[2], cntArr[6], cntArr[19]});

    cout << mn << '\n';
    cout << get_dna(n, cntArr, mn);
}
