#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string s;
    cin >> s;

    vector<int> cntArr(26);

    for (char c : s) {
        cntArr[c - 'a']++;
    }

    for (int cnt : cntArr) {
        cout << cnt << ' ';
    }
}
