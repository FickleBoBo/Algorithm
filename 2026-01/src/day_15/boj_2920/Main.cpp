#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    vector<int> v(8);
    for (int& x : v) cin >> x;

    bool isAsc = true;
    bool isDesc = true;

    for (int i = 1; i < 8; i++) {
        if (v[i] < v[i - 1]) {
            isAsc = false;
        }

        if (v[i] > v[i - 1]) {
            isDesc = false;
        }
    }

    if (isAsc) {
        cout << "ascending";
    } else if (isDesc) {
        cout << "descending";
    } else {
        cout << "mixed";
    }
}
