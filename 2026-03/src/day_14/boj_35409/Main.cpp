#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int h, m;
    cin >> h >> m;

    int x = h * 60 + m;
    if (6 * 60 + 30 <= x && x <= 9 * 60) {
        cout << "Yes";
    } else if (9 * 60 + 50 <= x && x <= 10 * 60) {
        cout << "Yes";
    } else if (10 * 60 + 50 <= x && x <= 11 * 60) {
        cout << "Yes";
    } else if (11 * 60 + 50 <= x && x <= 12 * 60) {
        cout << "Yes";
    } else if (12 * 60 + 50 <= x && x <= 13 * 60 + 50) {
        cout << "Yes";
    } else if (14 * 60 + 40 <= x && x <= 14 * 60 + 50) {
        cout << "Yes";
    } else if (15 * 60 + 40 <= x && x <= 15 * 60 + 50) {
        cout << "Yes";
    } else if (16 * 60 + 40 <= x && x <= 22 * 60 + 50) {
        cout << "Yes";
    } else {
        cout << "No";
    }
}
