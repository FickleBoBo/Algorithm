#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int A, B, C, D;
    cin >> A >> B >> C >> D;

    int numerator = A * D + B * C;  // 분자
    int denominator = B * D;        // 분모
    int g = gcd(numerator, denominator);

    cout << numerator / g << ' ' << denominator / g;
}
