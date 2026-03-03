#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int m, k;
    cin >> m >> k;

    if (m % k == 0) {
        cout << "Yes";
    } else {
        cout << "No";
    }
}
