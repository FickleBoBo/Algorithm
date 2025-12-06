#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string s;
    cin >> s;

    int cnt_arr[26] = {};
    for (char c : s) {
        cnt_arr[tolower(c) - 'a']++;
    }

    int mx = *max_element(cnt_arr, cnt_arr + 26);

    if (count(cnt_arr, cnt_arr + 26, mx) > 1)
        cout << '?';
    else {
        int idx = max_element(cnt_arr, cnt_arr + 26) - cnt_arr;
        cout << char(idx + 'A');
    }
}
