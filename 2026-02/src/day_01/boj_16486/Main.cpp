#include <bits/stdc++.h>
using namespace std;

const double PI = 3.141592;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int d1, d2;
    cin >> d1 >> d2;
    cout << fixed << setprecision(6) << d1 * 2 + 2 * d2 * PI;
}
