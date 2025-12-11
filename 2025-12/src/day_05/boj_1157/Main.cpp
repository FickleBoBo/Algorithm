#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string s;
    cin >> s;

    vector<int> cntArr(26);
    for (char c : s) {
        cntArr[tolower(c) - 'a']++;
    }

    int mx = *max_element(cntArr.begin(), cntArr.end());

    if (count(cntArr.begin(), cntArr.end(), mx) > 1)
        cout << '?';
    else {
        int idx = max_element(cntArr.begin(), cntArr.end()) - cntArr.begin();
        cout << char(idx + 'A');
    }
}
