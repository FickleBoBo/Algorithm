#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;

    int a = t / 300;
    t %= 300;

    int b = t / 60;
    t %= 60;

    int c = t / 10;
    t %= 10;

    if (t) {
        cout << -1;
    } else {
        cout << a << ' ' << b << ' ' << c;
    }
}
