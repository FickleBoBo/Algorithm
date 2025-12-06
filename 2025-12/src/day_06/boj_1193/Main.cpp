#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int x;
    cin >> x;

    int numerator = 1;    // 분자
    int denominator = 1;  // 분모
    int order = 1;
    while (order < x) {
        while (order < x && numerator > 1) {
            numerator--;
            denominator++;
            order++;
        }
        if (order == x) break;
        denominator++;
        order++;

        while (order < x && denominator > 1) {
            numerator++;
            denominator--;
            order++;
        }
        if (order == x) break;
        numerator++;
        order++;
    }

    cout << numerator << '/' << denominator;
}
