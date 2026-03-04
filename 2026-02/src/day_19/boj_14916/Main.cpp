#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    if (n % 5 == 0) {
        cout << n / 5;
    } else if (n >= 2 && (n - 2) % 5 == 0) {
        cout << (n - 2) / 5 + 1;
    } else if (n >= 4 && (n - 4) % 5 == 0) {
        cout << (n - 4) / 5 + 2;
    } else if (n >= 6 && (n - 6) % 5 == 0) {
        cout << (n - 6) / 5 + 3;
    } else if (n >= 8 && (n - 8) % 5 == 0) {
        cout << (n - 8) / 5 + 4;
    } else {
        cout << -1;
    }
}
