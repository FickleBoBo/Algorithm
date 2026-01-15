#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int prev = -1000000;

    int x;
    while (cin >> x) {
        if (x >= prev) {
            prev = x;
        } else {
            cout << "Bad";
            return 0;
        }
    }

    cout << "Good";
}
