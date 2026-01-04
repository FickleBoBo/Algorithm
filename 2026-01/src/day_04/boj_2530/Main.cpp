#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int a, b, c, d;
    cin >> a >> b >> c >> d;

    c += d;

    b += c / 60;
    c %= 60;

    a += b / 60;
    b %= 60;

    a %= 24;

    cout << a << ' ' << b << ' ' << c;
}
