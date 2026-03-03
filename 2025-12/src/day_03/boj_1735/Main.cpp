#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int a, b, c, d;
    cin >> a >> b >> c >> d;

    int numerator = a * d + b * c;  // 분자
    int denominator = b * d;        // 분모
    int g = gcd(numerator, denominator);

    cout << numerator / g << ' ' << denominator / g;
}
